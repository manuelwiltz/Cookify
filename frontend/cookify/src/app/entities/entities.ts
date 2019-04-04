export class Recipe {
    constructor(
        public id: string = '',
        public title: string = '',
        public subtitle: string = '',
        public thumbnail_url: string = '',
        public ingredients: [] = [],
        public time_sum: string = '',
        public time_cook: string = '',
        public description: string = '',
        public steps: [] = []
    ) {}
}

export class Drink {
    constructor(
        public id: string = '',
        public title: string = '',
        public subtitle: string = '',
        public thumbnail_url: string = '',
        public ingredients: [] = [],
        public time: string = '',
        public description: string = '',
        public steps: [] = []
    ) {}
}

export class Ingredient {
    constructor(
        public id: string = '',
        public name: string = '',
        public amount: string = '',
        public selected: boolean = false
    ) {}
}

export class Favorite {
    constructor(
        public id: string = '',
        public user_id: string = '',
        public recipe_id: string = '',
    ) {}
}