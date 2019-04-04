import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Recipe, Ingredient, Drink } from '../entities/entities';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private basicurl = 'http://localhost:8080/'

  constructor(private http: HttpClient) { }

  /**
   * RECIPE
  */
  public getAllRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.basicurl + 'recipe');
  }

  public getRecipeById(id: string): Observable<Recipe> {
    return this.http.get<Recipe>(this.basicurl + 'recipe/getById/' + id);
  }

  public getRecipeByTitle(title: string): Observable<Recipe> {
    return this.http.get<Recipe>(this.basicurl + 'recipe/getByTitle/' + title);
  }

  public getRecipeByIngredients(ingredients: Ingredient[]): Observable<Recipe> {
    return this.http.post<Recipe>(this.basicurl + 'recipe/getByIngredients/', ingredients);
  }

  public insertRecipe(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(this.basicurl + 'recipe/', recipe);
  }

  public updateRecipe(recipe: Recipe): Observable<Recipe> {
    return this.http.put<Recipe>(this.basicurl + 'recipe/', recipe);
  }

  public deleteRecipe(id: string): Observable<Recipe> {
    return this.http.delete<Recipe>(this.basicurl + 'recipe/delete/' + id);
  }

  /**
   * DRINK
  */
  public getAllDrinks(): Observable<Drink[]> {
    return this.http.get<Drink[]>(this.basicurl + 'drink');
  }

  public getDrinkById(id: string): Observable<Drink> {
    return this.http.get<Drink>(this.basicurl + 'drink/getById/' + id);
  }

  public getDrinksByTitle(title: string): Observable<Drink> {
    return this.http.get<Drink>(this.basicurl + 'drink/getByTitle/' + title);
  }

  public insertDrink(drink: Drink): Observable<Drink> {
    return this.http.post<Drink>(this.basicurl + 'drink/', drink);
  }

  public updateDrink(drink: Drink): Observable<Drink> {
    return this.http.put<Drink>(this.basicurl + 'drink/', drink);
  }

  public deleteDrink(id: string): Observable<Drink> {
    return this.http.delete<Drink>(this.basicurl + 'drink/delete/' + id);
  }

  /**
   * INGREDIENT
  */
  public getAllIngredients(): Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>(this.basicurl + 'ingredient');
  }

  public getIngredientByName(name: string): Observable<Ingredient> {
    return this.http.get<Ingredient>(this.basicurl + 'ingredient/getByName/' + name);
  }

  public insertIngredient(ingredient: Ingredient): Observable<Ingredient> {
    return this.http.post<Ingredient>(this.basicurl + 'ingredient/', ingredient);
  }

  public updateIngredient(ingredient: Ingredient): Observable<Ingredient> {
    return this.http.put<Ingredient>(this.basicurl + 'ingredient/', ingredient);
  }

  public deleteIngredient(id: string): Observable<Ingredient> {
    return this.http.delete<Ingredient>(this.basicurl + 'ingredient/delete/' + id);
  }

}
