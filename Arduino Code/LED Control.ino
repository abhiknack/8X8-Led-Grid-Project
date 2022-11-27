byte arrivingdatabyte;
int latchPin = 10;
int clockPin = 11;
int dataPin = 12;  
int freq = 1;
int convertBinary(long int a[]);
int a[8][8] = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
int c[8] = {0,0,0,0,0,0,0,0};
void setup( )  
{  
 
 Serial.begin(9600);
  pinMode(latchPin,OUTPUT);
  pinMode(clockPin,OUTPUT);
  pinMode(dataPin,OUTPUT);
  pinMode(2,OUTPUT);
  pinMode(3,OUTPUT);
  pinMode(4,OUTPUT);
  pinMode(5,OUTPUT);
  pinMode(6,OUTPUT);
  pinMode(7,OUTPUT);
  pinMode(8,OUTPUT);
  pinMode(9,OUTPUT);
  digitalWrite(2,HIGH);
  digitalWrite(3,HIGH);
  digitalWrite(4,HIGH);
  digitalWrite(5,HIGH);
  digitalWrite(6,HIGH);
  digitalWrite(7,HIGH);
  digitalWrite(8,HIGH);
  digitalWrite(9,HIGH);
}  
void loop( )  
{  
while(Serial.available( ) > 0)  
{  
  
arrivingdatabyte = Serial.read( );
if (arrivingdatabyte > 64){
    freq=pow(10,arrivingdatabyte - 65);
    break;
  }
  if (arrivingdatabyte == 0){
    for(int s=0;s<8;s++){
      for(int r=0;r<8;r++){
        a[s][r] = 0b0;
      }
      c[s] = 0b0;
    }
    break;
  }
int j,k;
 for(int n = 1 ;n<=64;n++){
        if(n == arrivingdatabyte){
           j = (n-1)/8;
           k = n%8;
           break;
           }
        }
          switch(k)
          {
            case 1:
            a[j][0] = 0b1;
            c[j]=convertBinary(a[j]);
            break;
            case 2:
            a[j][1] = 0b10;
            c[j]=convertBinary(a[j]);
            break;
            case 3:
            a[j][2] = 0b100;
            c[j]=convertBinary(a[j]);
            break;
            case 4:
            a[j][3] = 0b1000;
            c[j]=convertBinary(a[j]);
            break;
            case 5:
            a[j][4] = 0b10000;
            c[j]=convertBinary(a[j]);
            break;
            case 6:
            a[j][5] = 0b100000;
            c[j]=convertBinary(a[j]);
            break;
            case 7:
            a[j][6] = 0b1000000;
            c[j]=convertBinary(a[j]);
            break;
            case 0:
            a[j][7] = 0b10000000;
            c[j]=convertBinary(a[j]);
            break;
          }
        
       }
       for(int i = 0;i<=7;i++){
    
    if(i+2 > 2 && i+2 < 10){digitalWrite(i+1,HIGH);}
    if(i+2 == 2){digitalWrite(9,HIGH);}
    digitalWrite(latchPin,LOW);
    shiftOut(dataPin,clockPin, LSBFIRST,c[i]);
    digitalWrite(latchPin,HIGH);
    digitalWrite(i+2,LOW);
    
    delay(freq);
} 
 }
 int convertBinary(int a[]){
  int b = a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+a[6]+a[7];
        return b;
}
  

 