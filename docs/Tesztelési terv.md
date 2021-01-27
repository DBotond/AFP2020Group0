# Tesztelési terv

- Ez a dokumentáció a Wellness Badges projekt tesztelési fázisának lépéseit mutatja be. 

## Dokumentáció célja
- A tesztelések célja a rendszer és komponensei funkcionalitásának teljes vizsgálata, ellenőrzése, a rendszer által megvalósított üzleti szolgáltatások verifikálása.

- Útmutatást ad a projekt teszteléséhez.

- Tesztek ütemezése.

## Backend

- Szükséges hardver

    - PC
    
- Szükséges szoftver

    - Webböngésző
    
    - Webstorm

    - Swagger
    
- Ajánlott operációs rendszer a projekt teszteléséhez: Windows 8 vagy újabb

## Lépések

  1.Dockstation elindítás, projekt betöltése, buildelés, start
  
  2.Webstorm megnyitása, projekt elindítása
  
  3.Webböngésző megnyitása, swagger megnyitása
  
  4.POST metódus alkalmazása a swagger felületen 
  
  5.GET metódus alkalmazása a swagger felületen
  
  6.DELETE metódus alkalmazása a swagger felületen 
  
## Frontend

- Szükséges hardver

    - PC
    
- Szükséges szoftver

    - Webböngésző
    
    - Webstorm
    
    - Dockstation
    
- Ajánlott operációs rendszer a projekt teszteléséhez: Windows 8 vagy újabb

## Lépések

   1.Dockstation elindítás, projekt betöltése, buildelés, start
   
   2.Webstorm megnyitása, projekt elindítása
   
   3.Webböngésző megnyitása, swagger megnyitása
   
   4.Adat mezők kitöltése, Submit gomb megnyomása
   
   5.Oldal frissítése, Lista gomb lenyomása
   
   6.ID beállítása, törlés gomb megnyomása
   
   7.Ismétlés a billing szekciónál

## Tesztelési eljárások

  *Unit teszt:* Ahol csak lehetséges, szükséges már a fejlesztési idő alatt is tesztelni, hogy a metódusok megfelelően működnek-e. Ezért a metódusok megfelelő működésének biztosítására mindegyikhez írni kell Unit teszteket, a minél nagyobb kódlefedettséget szem előtt tartva. A metódusok akkor vannak kész, ha a tesztesetek hiba nélkül lefutnak az egyes metódusokon

  *Alfa teszt:* Fejlesztőcsapat teszteli a rendszert a felfedezett hibákat javítja, finomítja gyorsítja a rendszert szükség esetén

  *Beta teszt:* Kezdetleges rendszer telepítése a megrendelő által kívánt helyre és annak tesztelése egy héten át, problémák fellépése esetén jelezni azokat

## Tesztelendő funkciók
  *Backend Service:* Képesnek kell lennie adatokat fogadni és küldeni a karóráknak. Képesnek kell lennie egy időben kiszolgálni több klienst is. Fel kell tudnia tölteni, és le kell tudnia kérdezni az adatbázis adatait.

  *Karóra Adatmegadás:*
  Elvárt működés: A megadott adatokat az óra megfelelően tárolja, szükség esetén módisítható Szolgáltatások: Képesnek kell lennie kommunikációt biztosítani az adatbázis és az órák között. A karórán tárolt adatok segíségével meg kell tagadnia korhatáros szolgáltatásokat