import { Component, OnInit } from '@angular/core';
import { CreditCardService } from 'src/app/services/credit-card.service';
import { Subscription } from 'rxjs';
import { PagedList } from 'src/app/models/common/PagedList.class';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  pagedCreditCardsList : PagedList;

  loading : Subscription;

  constructor(private creditCardService : CreditCardService) { }

  ngOnInit() {
    this.getCardList(1);
  }

  getCardList(page : number){
    this.loading = this.creditCardService.getCreditCards(page).subscribe(response => {
      this.pagedCreditCardsList = response;
    },
    error =>{
      console.log(error);
    });
  }

  onPageChanged(page){
    this.getCardList(page);
  }

}
