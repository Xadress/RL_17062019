import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreditCard } from '../models/CreditCard.class';
import { HttpClient, HttpParams } from '@angular/common/http';
import { PagedList } from '../models/common/PagedList.class';
import { InsertUpdateCreditCardResponse } from '../models/InsertUpdateCreditCardResponse.class';

@Injectable({
  providedIn: 'root'
})
export class CreditCardService {

  baseUrl : string = 'api/credit-card/';

  constructor(private http : HttpClient) { }

  getCreditCards(page : number) : Observable<PagedList>{
    let url : string = this.baseUrl + 'list';
    let params = new HttpParams().set('page', page.toString());
    return this.http.get<PagedList>(url, {'params':params});
  };

  insertUpdateCreditCards(creditCards : CreditCard[]) : Observable<InsertUpdateCreditCardResponse>{
    let url : string = this.baseUrl + 'insert-update';
    return this.http.post<InsertUpdateCreditCardResponse>(url, creditCards);
  };
}
