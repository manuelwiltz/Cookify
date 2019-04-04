import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../service/http.service';
import { Recipe } from '../entities/entities';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  public recipes: Recipe[] = [];

  constructor(private router: Router, private httpService: HttpService) { }

  ngOnInit() {
    this.httpService.getAllRecipes().subscribe(data => {
      this.recipes = data;
    });
  }

  viewDetail(id: string) {
    this.router.navigate(['/recipe/:id', {id: id}]);
  }

}
