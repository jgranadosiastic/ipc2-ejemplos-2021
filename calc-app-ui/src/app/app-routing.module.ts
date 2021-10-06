import { HistorialDashboardComponent } from './historial-dashboard/historial-dashboard.component';
import { MainComponent } from './main-component/main.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: "",
    component: MainComponent
  },
  {
    path: "historial-dashboard",
    component: HistorialDashboardComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
