import { Component, inject, signal } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';

@Component({
  selector: 'app-main-links',
  templateUrl: './main-links.component.html',
  styleUrl: './main-links.component.css',
  standalone: true,
  imports: [RouterLink]
})
export class MainLinksComponent {

  private activatedRoute = inject(ActivatedRoute);

  isVisibleSandbox = signal<boolean>(false);  //this.activatedRoute.snapshot.queryParams['isVisibleSandbox'] === 'true');
  canAddCustomer = signal<boolean>(this.activatedRoute.snapshot.queryParams['canAddCustomer'] === 'true');

  constructor() {
    console.log("MainLinksComponent: isVisibleSandbox=" + this.isVisibleSandbox());
  }

}
