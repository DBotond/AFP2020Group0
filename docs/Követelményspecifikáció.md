# Wellnes Badges Software Requirements Specification

## **Áttekintés**

Egy wellness szállodának szeretnénk készpénz nélküli rendszert bevezetni, ahol vendégek könnyedén igénybe vehetnek
szolgáltatásokat. A vendégek kapnak egy órát, amely azonosítja őket. Amikor sok vendég megérkezik, mindenki megkapja 
a saját óráját, de lehetőség van rá, hogy közös számlán fizessenek.  Amikor a vendégek elmennek, visszaadják az új 
vendégeknek kijelölt órákat. A vendégek a PayPasshoz hasonló terminál megérintésével kényelmesen fizethetnek a 
különféle szolgáltatásokért.

Szeretnénk figyelemmel kísérni fogyasztásukat, és szükség esetén részletes számlát adni. 
Ezen túlmenően szeretnénk korlátozni a vendégek számára elérhető szolgáltatásokat, így bizonyos személyek számára 
bizonyos szolgáltatások nem lesznek elérhetőek(pl. a gyerekek nem vásárolhatnak alkoholt).
Bizonyos szolgáltatásokat emberek nyújtanak, például az italokat egy csapos szolgálja fel a bárban.
Mások automatizált szolgáltatások, mint például a szauna.

Az órák és az olvasók már telepítve vannak, és az interneten keresztül kommunikálnak a rendszerrel.
Ezek az eszközök képesek feldolgozni a választ, jóváhagyni vagy elutasítani a tranzakciót. Ezen eszközök
képesek egyszerű válasz üzenetek nyomtatására a hibáról, ha van. Például, ha egy gyermek  szaunázni akar, 
akkor a bejárati kapu elutasítja a kérését. Egy másik forgatókönyv szerint, ha egy 17 éves akar fizetni
akar az alkoholért, akkor a csapos üzenetet kap a korlátozásról.

## **Jelenlegi helyzet**

**A mostani helyzet általános problémái:**
- Hosszadalmas fizetési módszerek.
- Az ügyfélnek mindenhova magával kell vinnie a bankkártyát, vagy készpénzt.
- Több élőerőt kell alkalmazni, mint a teljesen automatizált rendszerünknél.
- Vendégek személyes adatai nem biztos, hogy védve vannak.
- Számla rendezés bonyolult lehet.
- Azonosítás nem biztos emberi tényezők miatt.

## **Vágyálom rendszer**

### Terjedés, azaz: kik fogják használni a rendszert

 A program egyaránt a szálloda üzemeltetőinek, és vendégeinek is készül. 
 A vendégeknek a gyors és akadálymentes fizetés, a szállodának a könnyű nyomon-
  követés, valamint a törvényi kötelezettségek betartása az érdeke. 
  Előreláthatólag három jogosultsági szint lesz, admin, belső felhasználó, és
  felhasználó.
  
### A szoftvernek egyértelmű üzeneteket kell küldenie
 
A vendégektől nem várható el, hogy számukra értelmezhetetlen üzeneteket
kapjanak egy esetleges hibáról, ezt széleskörűen kell unit-tesztelni a 
szoftvert, és minden felmerülő problémáról egyértelmű üzenetet kell kapniuk.
 
### A későbbiekben a szálloda bővülhet

A rendszernek fel kell készülnie rá, hogy új funkciók, új helyek kerülhetnek
a szálloda szolgáltatásai közé, ezeket esetleg egy minimális frissítéssel
kezelnie kell, hogy tudja.

### Rendszer specifikációs álmok

 A program müködtetésére szolgáló eszközök az alábbiak lesznek: 
- Egy leolvasó, ami fix helyekre, valamint mobil változatban is elérhető lesz.
- Egy karóra-szerű microchip-et tartalmazó szerkezet, amelyet a vendégek
hordanak a karukon, lehetővé téve a rendszer használatát.
- Szoftver, amivel a belső felhasználói, valamint az admin műveleteket lehet 
elvégzezni.

## **Funkcionális követelmény**

### *A belső felhasználók lehetőségei:*
 - A recepciós viszi be az adatokat, ő rendeli az emberekhez az azonosítót. - int(UID) | string(name) | int(age) | bool(TypeOfWatch)
 - A pincér lekérheti az illető korát, a kora ellenőrzéséhez. - int(UID) | int(age)
 - A pénzügyes kérheti le a fizetési adatok, és elkészíti a számlát. - int(UID) | int(TotalBill) | int(IndividualBill) | string(invoice)
 
### *A felhasználók lehetőségei:*
 - Lehetőségük van azonosítás után a szolgáltatásokat igénybevenni. - int(UID) | int(age)
 - Egyes hibaüzenetek esetén saját maguk is elháríthatják a hibákat, jelzi a hibát az üzemeltetőnek. - int(EID) | int(UID) | string(exception)
 
### *Az adminok lehetőségei:*
- Minden, a rendszer által nyújtott szolgáltatáshoz joguk van.

## **Jelenlegi üzleti folyamatok modellje**

A jelenlegi rendszer nagy munkaerőt kíván egy-egy munkatárs elvesztése kritikus lehet.
Az ügyfeleknek figyelniük kell értékeikre mivel fizetőeszközeiket nem hagyhatják egy zárható szekrényben
hiszen azok nélkül a különböző szolgáltatások igénybevétele nem lenne lehetséges. Sok vásárló
ezért kevés szolgáltatást vesz igénybe vagy akár egyántalán nem, csak az alapokat.

## **Igényelt üzleti folyamatok**

Az ügyfelek karórát kapnak, amit használhatnak a különféle szolgáltatások igénybevételéhez.
A kerórák kortól függően vannak beállítva, hogy a korhoz kötött szolgáltatásokat ne tudja bárki elérni.
Távozáskor igény szerint a rendszer számlát állít ki, amin követhető, hogy ki milyen szolgáltatásokat vett
igénybe, valamint a fizetés is utólag teljesül, hogy minél szabadabb legyen az egyes szolgáltatások igénybevétele.

## **Követelmény lista**

 *A rendszer tulajdonságai:*
 - Tartalmazza a vendégek adatait, de csak annyit, amennyi a rendszerhez kell. - int(UID) | string(name) | int(age) | bool(TypeOfWatch)
 - Képes lekérdezni az adatokat egy külső eszköz segítségével. - int(UID) | string(name) | int(age)
 - Képes szolgáltatások esetleges elutasítására az automatikus kor ellenőrző segíségével. - int(UID) | bool(allowed)
 - Nem automatizált rendszer esetén az automatikus kor ellenőrző figyelmezteti a kiszolgálót, ha szükséges. - int(UID) | bool(allowed)
 - Felhasználóbarát hibaüzenetek ad vissza, jelzi a hibát az üzemeltetőnek is. - int(EID) | int(UID) | string(ErrorMessage)
 - Képes közös számlát kiállítani több ügyfélnek együttesen, a karórákon lévő összeg alapján. - int(UID) | int(TotalBill) | int(IndividualBill)
 - Kijelentkezéskor a felszabadult azonosítókat új embereknek rendeli hozzá.
 

Modul | ID | Név | v. | Kifejtés
--- | --- | --- | --- |---
Jogosultság | F1 | Ügyfél adatainak megadása | 1.0 | Ügyfél nevének és életkorának tárolása, karórához való hozzárendelése
Jogosultság | F2 | Jogosultsági szintek | 1.0 | Felnőtt(18+): Mindent szolgáltatást igénybevehet<br/>Gyermek: Korhatáros szolgáltatásokhoz nem kap hozzáférést
Modifikáció | F3 | Ügyfél adatainak változtatása | 1.0 | Ügyfél nevének és életkorának változtatása
Igénybevétel | F4 | Gépi igénybevétel | 1.0 | Ajtó nyitása, automatás vásárlás korhatáros szolgáltatás esetén csak a megfelelő karórának
Igénybevétel | F5 | Emberi igénybevétel | 1.0 | Szolgáltatásoknál ahol szükséges munkatársat alkalmazni, ellátni egy leolvasó eszközzel
Igénybevétel | F6 | Számlázás | 1.0 | Szolgáltatás igénybevétele esetén fizetendő összeg hozzáadása az órához tartozó számlához
Ügyintézés | F7 | Számla kiállítás | 1.0 | Az igénybevett szolgáltatások kilístázása és erről való számla kiállítása
Ügyintézés | F8 | Fizetés | 1.0 | Az óra leolvasása és az igénybevett szolgáltatások alapján a fizetendő összeg meghatározása
Ügyintézés | F9 | Csoportos fizetés | 1.0 | Több órához tartozó számlák egyben történő kifizetése
Ügyintézés | F10 | Csoportos számla kiállítás | 1.0 | Több órához tartozó számlák egybevonása, egy listába rendezése
Jogosultság | F11 | Karóra felszabadítása | 1.0 | Ügyfél távozásakor a karóra adatai alaphelyzetbe állnak