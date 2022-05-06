export class Ninja{
    constructor(name, health){
        this.name = name;
        this.health = health;
        this.speed = 3;
        this.strength = 3;

    }

    sayName(){
        console.log('Ninja name is', this.name, '\n');
    }

    showStats(){
        console.log('Name:', this.name, '\n', 
                'Health:', this.health, '\n', 
                'Speed:', this.speed, '\n', 
                'Strength:', this.strength)
    }

    drinkSake(){
        this.health += 10;
    }


    
}

const ninja1 = new Ninja("Hyabusa", 10);

ninja1.drinkSake();
ninja1.sayName();
ninja1.showStats();