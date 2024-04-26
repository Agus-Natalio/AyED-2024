/*El esquema de comunicación de una empresa está organizado en una estructura jerárquica, en donde
cada nodo envía el mensaje a sus descendientes. Cada nodo posee el tiempo que tarda en transmitir el
mensaje.
Se debe devolver el mayor promedio entre todos los valores promedios de los niveles.
Para el ejemplo presentado, el promedio del nivel 0 es 14, el del nivel 1 es 16 y el del nivel 2 es 10. Por
lo tanto, debe devolver 16.
a) Indique y justifique qué tipo de recorrido utilizará para resolver el problema.
b) Implementar en una clase AnalizadorArbol, el método con la siguiente firma:
public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol)
Donde AreaEmpresa es una clase que representa a un área de la empresa mencionada y que contiene
la identificación de la misma representada con un String y una tardanza de transmisión de mensajes
interna representada con int.

a) Al tener que calcular nivel por nivel el maximo correspondiente al promedio de todos los nodos de cada nivel
 corresponde utilizar un recorrido por niveles

*/

package tp3.ejercicio4;

import java.util.List;
import tp1.ejercicio8.*;
import tp3.ejercicio1.GeneralTree;

public class AnalizadorArbol {
	@SuppressWarnings("unused")
	private double devolverMaximoPromedio(GeneralTree<AreaEmpresa> a) {
		Queue<GeneralTree<AreaEmpresa>> Q = new Queue<GeneralTree<AreaEmpresa>>();
		Q.enqueue(a);
		Q.enqueue(null);
		double maxProm = -1;
		int sumaAct = 0;
		int totalAct = 0;
		while(!Q.isEmpty()) {
			GeneralTree<AreaEmpresa> actual = Q.dequeue();
			if(actual != null) {
				sumaAct += actual.getData().getTardanza();
				totalAct++;
				List<GeneralTree<AreaEmpresa>> children = actual.getChildren();
				for(GeneralTree<AreaEmpresa> child: children) {
					Q.enqueue(child);
				}
			} else {
				if(!Q.isEmpty()) {
					double actProm = sumaAct / totalAct;
					if(maxProm < actProm) {
						maxProm = actProm;
					}
					sumaAct = 0;
					totalAct = 0;
					Q.enqueue(null);
				}
			}
		}
		return maxProm;
	}
}
