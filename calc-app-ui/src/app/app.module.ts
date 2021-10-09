import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { OperationFormComponent } from './operation-form/operation-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MainComponent } from './main-component/main.component';
import { HistorialDashboardComponent } from './historial-dashboard/historial-dashboard.component';
import { HistorialContainerComponent } from './historial-container/historial-container.component';
import { HistorialCardComponent } from './historial-card/historial-card.component';
import { HistorialTableComponent } from './historial-table/historial-table.component';
import { FilesComponent } from './files/files.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    OperationFormComponent,
    MainComponent,
    HistorialDashboardComponent,
    HistorialContainerComponent,
    HistorialCardComponent,
    HistorialTableComponent,
    FilesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
