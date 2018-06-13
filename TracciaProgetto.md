# PROGETTO COMPILATORI E INTERPRETI 2018

Il progetto consiste nella realizzazione di un compilatore per un linguaggio la cui sintassi deve comprendere quella di FOOL che si trova nel prototipo disponibile 
sul sito di e-learning.

Il progetto è una estensione object-oriented imperativa del linguaggio FOOL 
In particolare 

## ESPRESSIONI

Estensione delle espressioni con operatori ```<=```, ```>=```, ```||```, ```&&```, ```/```, ```-``` e ```not```

## COMANDI

Esiste la categoria sintattica stm:

```
stm : 	id = exp (assegnamento) ;
	| if exp then { stms } else { stms } (condizionale)
```
```	
stms :  ( stm )+
```
## OBJECT-ORIENTATION

* È possibile dichiarare classi e sottoclassi  al top level
* Le classi contengono 
  * campi (dichiarati nella classe o ereditati dalla super-classe) 
  * metodi (esplicitamente dichiarati nella classe o ereditati dalla super-classe). 
  
Se in una sottoclasse viene dichiarato un metodo con il medesimo nome 
di un metodo della super-classe, tale metodo sovrascrive quello della 
super-classe. Non è possibile avere overriding di campi.

Quindi, significa che occorre estendere 

* dichiarazioni
```
   class ID [extends ID] (...campi dichiarati come parametri...) { 
     ... metodi dichiarati come funzioni ... 
   }
```
* espressioni
```
   x.m(..)      // x e` un oggetto, m e` un metodo
   new C(..)	// C e` un identificatore di classe
   null
```
* comandi con ```x.m(..)```, se il metodo ritorna void

In particolare

* Gli oggetti nascono come istanza di classi
* I campi sono modificabili 
* Il linguaggio ha il comando di assegnamento
* Non è possibile dichiarare funzioni annidate. Le funzioni NON possono 
  essere passate come parametri
* È possibile avere funzioni/metodi mutuamente ricorsive.

## IL TYPE-CHECKER

Il compilatore deve comprendere un type-checker che controlli il corretto uso dei tipi. 
In particolare: 

* esiste il tipo void, oltre al tipo classe

* Si deve considerare una nozione di subtyping fra classi e tipi di funzioni. Il tipo 
  di una funzione f1 è sottotipo del tipo di una funzione f2 se il tipo ritornato da f1 
  è sottotipo del tipo ritornato da f2, se hanno il medesimo numero di parametri, e se  
  ogni tipo di parametro di f1 è sopratipo del corrisponde tipo di parametro di f2. 
  Una classe C1 è sottotipo di una classe C2 se C1 estende C2 e se i campi e metodi che 
  vengono sovrascritti sono sottotipi rispetto ai campi e metodi corrispondenti di C2. 
  Inoltre, C1 è sottotipo di C2 se esiste una classe C3 sottotipo di C2 di cui C1 è 
  sottotipo.

* definire e implementare le regole di tipaggio per tutti i costrutti, in 
particolare per il condizionale. 

## IL CODICE OGGETTO

Il compilatore deve generare codice per un esecutore virtuale chiamato SVM (stack 
virtual machine) la cui sintassi è definita nel file SVM.g. Tale esecutore ha una 
memoria in cui gli indirizzi alti sono usati per uno stack. Uno stack pointer punta alla 
locazione successiva alla prossima locazione libera per lo stack (se la memoria ha 
indirizzi da 0 a MEMSIZE-1, lo stack pointer inizialmente punta a MEMSIZE). 
In questo modo, quando lo stack non e` vuoto, lo stack pointer punta al top dello stack. 

Il programma è collocato in una memoria separata puntata dall'instruction pointer 
(che punta alla prossima istruzione da eseguire). Gli altri registri della macchina 
virtuale sono: HP (heap pointer), RA (return address), RV (return value) e FP 
(frame pointer). 
In particolare, HP serve per puntare alla prossima locazione disponibile dello 
heap; assumendo di usare gli indirizzi bassi per lo heap, HP contiene inizialmente 
il valore 0.

* Implementare tutte le operazioni per le nuove espressioni
* Implementare il dynamic dispatch ==> implementare e definire layout oggetti e classi
(vedi lezioni)
* La generazione di codice oggetto è fatta utilizzando una grammatica con attributi,
vedere SVM.g4).
Definire una grammatica SENZA attributi (come FOOL.g4) e definire una visita 
dell'albero sintattico per generare il codice.

## OPZIONALI

La deallocazione degli oggetti nello heap (garbage collection) NON È OBBLIGATORIA.
Chi è interessato può scrivere il modulo relativo.


