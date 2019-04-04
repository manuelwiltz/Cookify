import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RecipeComponent } from './recipe/recipe.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CreateComponent } from './create/create.component';
import { EditComponent } from './edit/edit.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpService } from './service/http.service';
import { DrinkComponent } from './drink/drink.component';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { DrinkDashboardComponent } from './drink-dashboard/drink-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    RecipeComponent,
    PageNotFoundComponent,
    CreateComponent,
    EditComponent,
    DashboardComponent,
    DrinkComponent,
    IngredientsComponent,
    DrinkDashboardComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    HttpService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
