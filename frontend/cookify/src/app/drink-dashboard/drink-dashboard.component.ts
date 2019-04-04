import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../service/http.service';
import { Drink } from '../entities/entities';

@Component({
  selector: 'app-drink-dashboard',
  templateUrl: './drink-dashboard.component.html',
  styleUrls: ['./drink-dashboard.component.scss']
})
export class DrinkDashboardComponent implements OnInit {

  public drinks: Drink[] = [];

  constructor(private router: Router, private httpService: HttpService) { }

  ngOnInit() {
    this.httpService.getAllDrinks().subscribe(data => {
      this.drinks = data;
    });
  }

  viewDetail(id: string) {
    this.router.navigate(['/drink/:id', {id: id}]);
  }

}
