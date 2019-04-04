import { Component, OnInit } from '@angular/core';
import { Recipe } from '../entities/entities';
import { HttpService } from '../service/http.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.scss']
})
export class RecipeComponent implements OnInit {

  public id: string = '';
  public recipe: Recipe = new Recipe();

  constructor(private route: ActivatedRoute,
    private httpService: HttpService,
    private router: Router) {
}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
      this.httpService.getRecipeById(this.id).subscribe(data => {
        this.recipe = data;
      }, (error) => {
        console.log(error);
      });
    });
  }

  update() {
    this.router.navigate(['/edit/:id', {id: this.id}]);
  }

  delete() {
    this.httpService.deleteRecipe(this.id);
  }

}
