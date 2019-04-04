import { Component } from '@angular/core';
import { HttpService } from './service/http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'cookify';

  constructor(private router: Router, private httpService: HttpService) {}

  createRecipe() {
    this.router.navigate(['/create']);
  }

}
