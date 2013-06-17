program Sort(input, output);


type
    TBookRec = record
                ISBN  : string;
                Price : int;
               end;

    TBookRec1 = record
                ISBN  : string;
                Price : int;
                t1   : TBookRec;
               end;

Var
    myVar   : int;
    myArray : Array[5,5] of int;
Begin

 myArray[2][0]:=  6; 
 myVar := myArray[2][0];
 writeln(myArray[2][0]);
End.
