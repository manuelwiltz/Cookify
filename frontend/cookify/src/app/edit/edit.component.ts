import { Component, OnInit } from '@angular/core';
import { Recipe } from '../entities/entities';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../service/http.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  public id: string = '';
  public recipe: Recipe = new Recipe;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private httpService: HttpService
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
      this.httpService.getRecipeById(this.id).subscribe(data => {
        this.recipe = data;
      }, () => {
        this.router.navigate(['dashboard']);
      });
    });
  }

  updateRecipe() {
    this.httpService.updateRecipe(this.recipe).subscribe(data => {
      this.router.navigate(['/recipe/:id', { id: this.recipe.id }]);
    }, (error) => {
      console.log(error);
    });
  }

}
