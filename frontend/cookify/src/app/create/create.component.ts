import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../service/http.service';
import { Recipe } from '../entities/entities';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {

  public recipe: Recipe = new Recipe;
  public newRecipe: Recipe = new Recipe;

  constructor(
    private router: Router,
    private httpService: HttpService
  ) { }

  ngOnInit() {
    this.recipe.ingredients.push();
    this.recipe.steps.push();
  }

  createRecipe() {
    if (this.recipe.title !== '' && this.recipe.subtitle !== '') {
      this.httpService.insertRecipe(this.recipe).subscribe(data => {
        this.newRecipe = data;
        this.recipe = new Recipe();
        this.router.navigate(['/dashboard']);
      }, error => {
        console.log(error);
      });
    } 
  }

}
