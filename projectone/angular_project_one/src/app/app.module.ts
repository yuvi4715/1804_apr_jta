import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { DatabaseGetterService } from './database-getter.service';
import { AppRoutingModule,routingComponents} from './app-routing.module';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    ViewEmployeeComponent
  ],
  imports: [
    BrowserModule,
	FormsModule,
	HttpClientModule,
	AppRoutingModule
  ],
  providers: [DatabaseGetterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
