// import {Ninja} from './Ninja.js'

class Ninja{
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
        console.log(`\nName: ${this.name}\nHealth: ${this.health}\nSpeed: ${this.speed}\nStrenth: ${this.strength}\n`)
    }

    drinkSake(){
        this.health += 10;
    }
}

class Sensei extends Ninja{
    constructor(name,){
        super(name, 200);
        this.speed = 10;
        this.strength = 10;
        this.wisdom = 10;
    }

    speakWisdom(){
        this.drinkSake();
        console.log('Wisdom:', this.wisdom)
    }

}

const ninja1 = new Ninja("Hyabusa", 10);

ninja1.drinkSake();
ninja1.sayName();
ninja1.showStats();

// example output
const superSensei = new Sensei("Master Splinter");

superSensei.speakWisdom();
// -> "What one programmer can do in one month, two programmers can do in two months."
superSensei.showStats();
// -> "Name: Master Splinter, Health: 210, Speed: 10, Strength: 10"