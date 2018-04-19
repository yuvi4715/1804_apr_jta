//This example provides template literals, arrow notation, and callback functions,
//in combination of closures.
console.log('--Closure--');
var Person = function(id, name, age) {
    //Constructor logic
    this.id = id;
    this.name = name;
    this.age = age;

    //We return our closure (callback functions)
    return {
        //Getters and Setters
        //If we use function() instead, it won't work, it will create
        //its own this object.
        getId: () => {
            return this.id;
        },
        setId: (id) => {
            this.id = id;
        },
        getName: () => {
            return this.name;
        },
        setName: (name) => {
            this.name = name;
        },
        getAge: () => {
            return this.age;
        },
        setAge: (age) => {
            this.age = age;
        },
        print: () => {
            return `id:  ${this.id}, name: ${this.name}, age: ${this.age}`
        }
    }
}

//Object creation
var peter = new Person(1, 'Peter', 132);
console.log(peter.id) //We can't it's "private".

//Getting members
console.log(`id:  ${peter.getId()}, name: ${peter.getName()}, age: ${peter.getAge()}`);

//Setting members
peter.setId(5);
console.log(peter.print());