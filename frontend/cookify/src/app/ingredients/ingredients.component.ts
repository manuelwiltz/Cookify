import { Component, OnInit } from '@angular/core';
import { Ingredient, Recipe } from '../entities/entities';
import { HttpService } from '../service/http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ingredients',
  templateUrl: './ingredients.component.html',
  styleUrls: ['./ingredients.component.scss']
})
export class IngredientsComponent implements OnInit {

  public ingredients: Ingredient[] = [];

  constructor(private httpService: HttpService, private router: Router) { }

  ngOnInit() {
    this.httpService.getAllIngredients().subscribe(data => {
      this.ingredients = data;
    });
  }

}
