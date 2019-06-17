import { BaseForm } from 'src/app/models/common/BaseForm.class';
import { Validators } from '@angular/forms';

export class InsertCardsForm extends BaseForm{

    constructor(){
        super();
        this.form = this.fb.group({
            bankName : ['', [
              Validators.required
            ]],
            cardNumber : ['', [
              Validators.required,
              Validators.maxLength(16)
            ]],
            expiryDate : ['', [
              Validators.required
            ]]
          });
    }

    get BankName(){
        return this.form.get('bankName');
    }

    get CardNumber(){
        return this.form.get('cardNumber');
    }
    
    get ExpiryDate(){
        return this.form.get('expiryDate');
    }
    
}