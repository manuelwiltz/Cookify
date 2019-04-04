import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {DashboardComponent} from './dashboard/dashboard.component';
import { RecipeComponent } from './recipe/recipe.component';
import { EditComponent } from './edit/edit.component';
import { CreateComponent } from './create/create.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { DrinkComponent } from './drink/drink.component';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { DrinkDashboardComponent } from './drink-dashboard/drink-dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'drinkDashboard', component: DrinkDashboardComponent },
  { path: 'ingredients', component: IngredientsComponent },
  { path: 'recipe/:id', component: RecipeComponent },
  { path: 'drink/:id', component: DrinkComponent },
  { path: 'edit/:id', component: EditComponent },
  { path: 'create', component: CreateComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }