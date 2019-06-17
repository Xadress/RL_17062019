import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { CreditCardService } from 'src/app/services/credit-card.service';
import { InsertCardsForm } from './InsertCardsForm.class';
import { CreditCard } from 'src/app/models/CreditCard.class';
import { Papa } from 'ngx-papaparse';
import { ToastrService } from 'ngx-toastr';
import * as moment from 'moment';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  insertCardsForm: InsertCardsForm;
  cardsToInsert: CreditCard[];

  loading: Subscription;

  constructor(private creditCardService: CreditCardService, private csvParser: Papa, private toastr : ToastrService) {
    this.insertCardsForm = new InsertCardsForm();
  }

  ngOnInit() {
    this.cardsToInsert = [];
  }

  saveCards() {
    if (this.cardsToInsert && this.cardsToInsert.length) {
      this.loading = this.creditCardService.insertUpdateCreditCards(this.cardsToInsert).subscribe(response => {
        if(response.discardedCCs.length > 0){
          this.toastr.warning("Some cards were discarded because were not well-formed. Please correct them and try again.");
        }

        if(response.insertedCCs.length>0){
          this.toastr.success(response.insertedCCs.length + 
            (response.insertedCCs.length>1 ? " cards" : " card") + " correctly added to your list!");
        }

        this.cardsToInsert = response.discardedCCs;
      }, error => {
        console.log(error);
      });
    }
  }

  addEmptyCard() {
    this.cardsToInsert.push(new CreditCard());
  }

  removeCard(card: CreditCard) {
    const index = this.cardsToInsert.indexOf(card, 0);
    if (index > -1) {
      this.cardsToInsert.splice(index, 1);
    }
  }

  onCsvFileLoaded(event) {

    let fileReader = new FileReader();
    fileReader.readAsText(event.target.files[0]);

    /* READ CSV FILE */
    fileReader.onload = (e) => {
      console.log("File content: ");
      console.log(fileReader.result);

      let csvData = fileReader.result as string;

      /* START CSV FILE PARSING */
      this.csvParser.parse(csvData, {
        complete: (result) => {
          console.log('Parsed: ', result);

          if (result.errors.length === 0) {
            for (let entry of result.data) {
              let dateToFormat =  moment(entry[2], "MM-YYYY").toDate();
              let expiryDate = moment(dateToFormat).format("YYYY-MM-DD");
              let newCard = new CreditCard(entry[0], entry[1], expiryDate);
              this.cardsToInsert.push(newCard);
            }

          }else{
            for(let err of result.errors){
              this.toastr.error(err.message);
            }
            this.toastr.error("Oops! There's something wrong with your CSV file");
          }

        },
        error: (error, file) => {
          console.log("Error while parsing csv: ");
          console.log(error);
          console.log(file);
        }
      });

    }

  }

  parseExpiryDate(entry : string) : Date{

      if(entry!=null && entry.length>0){

      }
      return null;
  }

}
