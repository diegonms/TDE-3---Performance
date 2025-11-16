# TDE-3---Performance

## Links
Youtube: https://www.youtube.com/watch?v=3k0s92hhsGw

## Jantar dos Filósofos

O Jantar dos Filósofos é um problema clássico de concorrência usado para ilustrar situações onde múltiplos processos competem por recursos compartilhados.
Os filósofos estão sentados em uma mesa circular com um garfo entre cada par. Para comer, cada filósofo precisa pegar dois garfos: o da esquerda e o da direita.

O jantar dos filósofos modela threads concorrendo por recursos.
- Filósofos → threads
- Garfos → locks
- Comer → exige dois recursos simultâneos

Cada filósofo alterna entre.

-Pensar\
-Ficar com fome\
-Comer (se conseguir ambos os garfos)

Sem um controle adequado, todos podem pegar um garfo e esperar eternamente pelo outro, causando um **deadlock **(impasse). 

## Threads e Semáforos

Um semáforo controla o acesso a um recurso compartilhado por meio de contagem de “permissões”;
adquirir bloqueia quando não há permissões e liberar devolve permissões, podendo funcionar como
exclusão mútua quando inicializado com um único alvará (binário).  
Isso é importante porque garante que só uma thread de cada vez entre na parte crítica do código, evitando condições de corrida.

## Deadlock

Deadlock é a situação em que um conjunto de processos ou threads não progride porque cada um aguarda
uma ação do outro, tipicamente a liberação de um lock, sendo necessário que quatro condições ocorram
simultaneamente: exclusão mútua, manter-e-esperar, não preempção e espera circular (Condições de
Coffman).

