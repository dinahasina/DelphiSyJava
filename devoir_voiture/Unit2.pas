unit Unit2;

interface

type
  Voiture = class
    public
      marque,types:string;
      entretien,consomation,km,reservoire,cap_reservoire,km_total,etape:real;
    public
      constructor create();
      procedure parcourir(d:real);
      procedure plein();
      procedure vidange();
      function getReservoire():Real;
      function getVidange():Real;
      function getKm():Real;
  end;

implementation
constructor Voiture.create();
begin

end;


function Voiture.getReservoire():Real;
begin
   getReservoire:= (self.reservoire * 100)/self.cap_reservoire;
end;

function Voiture.getVidange():Real;
begin
   getVidange:= (self.entretien * 100)/5000;
end;

function Voiture.getKm():Real;
begin
   getKm:= (self.km * 100)/self.km_total;
end;

procedure Voiture.parcourir(d:real);
var canRun:real;
begin

      canRun:= self.reservoire - ((d*self.consomation)/100);
      if(canRun >= 0)then
      begin
          self.km := self.km + d;
          self.reservoire :=  self.reservoire - ((d * self.consomation)/100);
          self.entretien:= self.entretien +  self.km
      end
      else
      begin
        self.km:= self.km + ((self.cap_reservoire*100)/self.consomation);
        self.reservoire:= 0;
        self.entretien:= self.entretien +  ((self.cap_reservoire*100)/self.consomation);
      end;

end;

procedure Voiture.plein();
begin
    self.reservoire:=self.cap_reservoire;
end;

procedure Voiture.vidange();
begin
     self.entretien:=0;
end;

end.
