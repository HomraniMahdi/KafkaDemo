import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Order {
  customerName: string;
  product: string;
  quantity: number;
}

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private http = inject(HttpClient);

  private apiUrl = 'http://localhost:8080/api/orders';

  createOrder(order: Order): Observable<string> {
    return this.http.post(
      this.apiUrl,
      order,
      {
        responseType: 'text'
      }
    );
  }
}