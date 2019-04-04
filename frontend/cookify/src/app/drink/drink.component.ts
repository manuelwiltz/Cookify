import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../service/http.service';
import { Drink } from '../entities/entities';

@Component({
  selector: 'app-drink',
  templateUrl: './drink.component.html',
  styleUrls: ['./drink.component.scss']
})
export class DrinkComponent implements OnInit {

  public id: string = '';
  public drink: Drink = new Drink();

  constructor(private route: ActivatedRoute,
    private httpService: HttpService,
    private router: Router) {
}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
      this.httpService.getDrinkById(this.id).subscribe(data => {
        this.drink = data;
      }, (error) => {
        console.log(error);
      });
    });
  }

  update() {
    //this.router.navigate(['/edit/:id', {id: this.id}]);
  }

  delete() {
    this.httpService.deleteRecipe(this.id);
  }

}
