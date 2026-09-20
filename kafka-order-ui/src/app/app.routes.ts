import { Routes } from '@angular/router';
import { OrderComponent } from './order/order.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'orders',
    pathMatch: 'full'
  },
  {
    path: 'orders',
    component: OrderComponent
  }
];