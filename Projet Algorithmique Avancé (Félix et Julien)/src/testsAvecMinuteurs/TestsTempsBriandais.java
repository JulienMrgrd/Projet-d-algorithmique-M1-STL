package testsAvecMinuteurs;

import java.math.BigDecimal;
import java.math.MathContext;

import arbreBriandais.ArbreBriandais;

/**
 * Classe permettant de tester différents temps de traitement basée sur
 * l'oeuvre complète de W. Shakespeare à l'aide d'un arbre de la Briandais
 */
public class TestsTempsBriandais extends TestsTempsSuperclass {
	
//  Liste de la classe mère TestsTempsSuperclass
//	protected static List<BigDecimal> tpsConstruction;  
//	protected static List<BigDecimal> tpsInsertions;  
//	protected static List<BigDecimal> tpsRecherche;  
//	protected static List<BigDecimal> tpsSuppression;  
//	protected static List<BigDecimal> tpsComptageMots; 
	
	public TestsTempsBriandais(){
		super();
		arbre = new ArbreBriandais();
	}
	
	public void resetArbre(){
		arbre = new ArbreBriandais();
	}

	@Override
	protected BigDecimal tempsConstruction() {
		long time_before = System.nanoTime();
		for(String mot : liste_mots) arbre.insererMot(mot);
		long time_after = System.nanoTime();

		return new BigDecimal((time_after - time_before)/1000000.0 ,new MathContext(6));
	}

	@Override
	protected BigDecimal tempsInsertion(String mot) {
		long time_before = System.nanoTime();
		arbre.insererMot(mot);
		long time_after = System.nanoTime();

		return new BigDecimal((time_after - time_before)/1000000.0 ,new MathContext(6));
	}

	@Override
	protected BigDecimal tempsRecherche(String mot) {
		long time_before = System.nanoTime();
		arbre.rechercherMot(mot);
		long time_after = System.nanoTime();

		return new BigDecimal((time_after - time_before)/1000000.0 ,new MathContext(6));
	}

	@Override
	protected BigDecimal tempsSuppression(String mot) {
		long time_before = System.nanoTime();
		arbre.suppression(mot);
		long time_after = System.nanoTime();

		return new BigDecimal((time_after - time_before)/1000000.0 ,new MathContext(6));
	}

	@Override
	protected BigDecimal tempsComptageMots() {
		long time_before = System.nanoTime();
		arbre.comptageMots();
		long time_after = System.nanoTime();

		return new BigDecimal((time_after - time_before)/1000000.0 ,new MathContext(6));
	}
	
	
}
