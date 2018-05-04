import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'; //Bring in our httpClient library
@Component({
    selector: 'app-poke',
    templateUrl: './pokeapi.component.html'
})

export class PokeapiComponent{
    public pokeId;
    public pkmn = {
        name: "",
        id: "",
        weight: "",
        sprite: "",
        sprites: [],
        spriteIndex: 0
    }

    //Constructor will execute upon instantiation of the class.
    //We can use a constructor to inject objects from other classes
    //into our class for use.
    //In this case, we will inject the HttpClient class
    constructor(private http: HttpClient){

    }
    /*
        Promise Vs Observable
        
        Angular uses Observable objects when making asynchronous calls.

        A Promise is a type of object where when a user sends data,
        we are gaurnateed to get something back. In the case of sending a request,
        we either get back an object representing the data recieved, or an object
        representing the error we recieved.
        Promises can only listen on one event at a time, on top of which, a user
        cannot cancel the event once started. IE, I cant halt a request sent to 
        a server, I must wait for some kind of response to come back.

        Observables are the same as promises except with more features. Observables
        send the data back, essentially, as a stream. With that, Observables can
        provide support for 0-many events at a time. Observable also supports
        canceling the event.
    */
    public fetchData(){
        this.pkmn.name = "Pending";
        this.pkmn.id = "Pending";
        this.pkmn.weight = "Pending";
        this.pkmn.sprite = "https://media.giphy.com/media/3oEjI6SIIHBdRxXI40/giphy.gif";

        this.pkmn.sprites = [];
        this.pkmn.spriteIndex = 0;
 
        //Example of POST
        /*
        this.http.post("endpoint_url", {
                                            key1: "value",
                                            key2: "value",
                                            etc : "value"
                                        }).subscribe(
                                            PASS => {}, 
                                            FAIL => {})
*/
        this.http.get('https://pokeapi.co/api/v2/pokemon/' + this.pokeId + '/').subscribe(
            data => { //data represents the object of a successful REST request
                console.log("test");
                this.pkmn.name = data["name"];
                this.pkmn.id = data["id"];
                this.pkmn.weight = data["weight"];
                
                let dataSprites = data["sprites"];
                for(let index in dataSprites){
                    if(dataSprites[index]!=null){
                        this.pkmn.sprites.push(dataSprites[index]);
                        if(index=="front_default"){
                            this.pkmn.sprite = dataSprites[index];
                            this.pkmn.spriteIndex = this.pkmn.sprites.length-1;
                        }
                    }
                }
            },
            err => {
                this.pkmn.name = "MissingNo";
                this.pkmn.id = "-1";
                this.pkmn.weight = "What?";
                this.pkmn.sprite = "https://sites.google.com/a/sutamii.com/sutamii-shimeji/_/rsrc/1286733155717/shimeji/missingno.png";                
            }
        )
    }
    public changePicture(){
        let sprites = this.pkmn.sprites;
        let index = this.pkmn.spriteIndex;
        if(sprites[index+1]==undefined){
            this.pkmn.sprite = sprites[0];
            this.pkmn.spriteIndex = 0;
        }else{
            this.pkmn.sprite = sprites[++index];
            this.pkmn.spriteIndex = index;
        }
    }

}