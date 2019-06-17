import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import {NgBusyModule} from 'ng-busy';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { PapaParseModule } from 'ngx-papaparse';
import { ToastrModule } from 'ngx-toastr';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreditCardService } from './services/credit-card.service';
import { MainComponent } from './components/main/main.component';
import { ManagerComponent } from './components/manager/manager.component';

const appRoutes : Routes = [
  {path: '', component: MainComponent},
  {path: 'manager', component: ManagerComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    ManagerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    RouterModule.forRoot(appRoutes),
    NgBusyModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    FormsModule,
    PapaParseModule,
    ToastrModule.forRoot()
  ],
  providers: [CreditCardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
