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

    TBookRec2 = record
                ISBN  : string;
                Price : int;
                t2   : TBookRec1;
               end;

  
var    
    struct : TBookRec2;
    struct1 : TBookRec1;
    x : int;
                 
begin
   x:=5;
    struct.t2.t1.Price:= 100;
   
    struct1.Price := struct.t2.t1.Price;

   writeln(struct1.Price);
   
end.