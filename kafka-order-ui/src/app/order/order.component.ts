import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';

import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-order',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './order.component.html',
  styleUrl: './order.component.css'
})
export class OrderComponent {

  private fb = inject(FormBuilder);
  private orderService = inject(OrderService);

  message = '';

  form = this.fb.nonNullable.group({
    customerName: ['', Validators.required],
    product: ['', Validators.required],
    quantity: [1, [
      Validators.required,
      Validators.min(1)
    ]]
  });

  submit(): void {

    console.log('1 - Submit appelé');

    if (this.form.invalid) {
      console.log('2 - Formulaire invalide');

      this.form.markAllAsTouched();
      return;
    }

    console.log('2 - Formulaire valide');

    const order = this.form.getRawValue();

    console.log('3 - Objet envoyé au backend :', order);

    this.orderService.createOrder(order).subscribe({

      next: (response) => {
        console.log('4 - Réponse backend :', response);

        this.message = 'Commande créée avec succès !';

        this.form.reset({
          customerName: '',
          product: '',
          quantity: 1
        });
      },

      error: (error) => {
        console.error('4 - ERREUR HTTP :', error);
        console.error('Status :', error.status);
        console.error('Message :', error.message);
        console.error('Error :', error.error);

        this.message =
          `Erreur HTTP ${error.status} : ${error.message}`;
      }
    });
  }
}