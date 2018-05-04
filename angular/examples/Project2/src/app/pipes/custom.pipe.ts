import { Injectable, Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'custompipe'
})
@Injectable()
export class CustomPipe implements PipeTransform{
    transform(input:string):string{
        let x = "";

        let count = 0;
        for(let letter of input){
            count++;
            if(!(count%3)){
                x += letter.toUpperCase();
            }else{
                x += letter;
            }
            
        }

        return x;
    }
}