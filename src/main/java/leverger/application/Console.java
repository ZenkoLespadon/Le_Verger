package leverger.application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import leverger.contenu.Arbre;
import leverger.contenu.Dé;
import leverger.contenu.Face;
import leverger.contenu.Fruit;
import leverger.contenu.VueDé;

public class Console extends Application {
	
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();
		GridPane verger = new GridPane();
		verger.setVisible(true);
		
		
		Arbre pommier = new Arbre(Fruit.POMME);
		Arbre prunier = new Arbre(Fruit.PRUNE);
		Arbre poirier = new Arbre(Fruit.POIRE);
		Arbre cerisier = new Arbre(Fruit.CERISE);
		
		ImageView vuePommier = new ImageView(pommier.image);
		vuePommier.setFitWidth(400);
		vuePommier.setFitHeight(425);
		
		ImageView vuePrunier = new ImageView(prunier.image);
		vuePrunier.setFitWidth(400);
		vuePrunier.setFitHeight(425);
		
		ImageView vuePoirier = new ImageView(poirier.image);
		vuePoirier.setFitWidth(400);
		vuePoirier.setFitHeight(425);
		
		ImageView vueCerisier = new ImageView(cerisier.image);
		vueCerisier.setFitWidth(400);
		vueCerisier.setFitHeight(425);
		
		
		StackPane conteneurPommier = new StackPane();
		conteneurPommier.getChildren().add(vuePommier);
		imgPomme(conteneurPommier);
		
		StackPane conteneurCerisier = new StackPane();
		conteneurCerisier.getChildren().add(vueCerisier);
		imgCerise(conteneurCerisier);
	
		StackPane conteneurPoirier = new StackPane();
		conteneurPoirier.getChildren().add(vuePoirier);
		imgPoire(conteneurPoirier);
		
		StackPane conteneurPrune = new StackPane();
		conteneurPrune.getChildren().add(vuePrunier);
		imgPrune(conteneurPrune);
		
		ImageView backgrounds = new ImageView(new Image("file:img/Background.png"));
		backgrounds.setFitWidth(1600);
		backgrounds.setFitHeight(900);
		
		Dé dé = new Dé();
		int[] tour = { 1 };

		VueDé vueDé = new VueDé(dé, Color.BLACK);
		Label labelTour = new Label("Tour : " + tour[0]);
		labelTour.setLayoutX(20);
		labelTour.setLayoutY(20);

		vueDé.paneDé.setOnMouseClicked(event -> {
		    Face faceTiree = dé.lancerDé();
		    vueDé.cercle.setFill(faceTiree.couleur);
		    tour[0]++; // Incrémentez la valeur de tour
		    labelTour.setText("Tour : " + tour[0]); // Mettre à jour le label avec la nouvelle valeur de tour
		});
		
		StackPane Compteur = new StackPane();
		Compteur.setPadding(new Insets(450,0,0,320));
		Compteur.getChildren().add(labelTour); 

		
		
		
		verger.add(conteneurPommier, 0, 0);
		verger.add(conteneurPrune, 1, 0);
		verger.add(conteneurPoirier, 2, 0);
		verger.add(conteneurCerisier, 3, 0);
		verger.add(Compteur, 3, 1);
		
		//root.add(vueCerise, 0, 1);//
		root.getChildren().add(backgrounds);
		root.getChildren().add(verger);
		
		
		
		root.getChildren().add(vueDé.paneDé);
		Scene scene = new Scene(root, 1600, 900);
		primaryStage.setScene(scene);
		primaryStage.show();
		//CHANGEMENT
	}
	
	
	


	private void imgPomme(StackPane conteneurPommier) {
		
		GridPane mesPommes = new GridPane();
		mesPommes.setPadding(new Insets (60,0,0,75));
		
		
		for (int row = 0; row < 2; row++) {
		    for (int col = 0; col < 5; col++) {
		    	ImageView vuePomme = new ImageView(Fruit.POMME.image);
				vuePomme.setFitWidth(50);
				vuePomme.setFitHeight(50);
				mesPommes.add(vuePomme, col, row);
		    }
		}

		conteneurPommier.getChildren().add(mesPommes);
	}
	
private void imgCerise(StackPane conteneurCerisier) {
		
		GridPane mesCerises = new GridPane();
		mesCerises.setPadding(new Insets (60,0,0,75));
		
		
		for (int row = 0; row < 2; row++) {
		    for (int col = 0; col < 5; col++) {
		    	ImageView vueCerise = new ImageView(Fruit.CERISE.image);
		    	vueCerise.setFitWidth(50);
		    	vueCerise.setFitHeight(50);
		    	mesCerises.add(vueCerise, col, row);
		    }
		}

		conteneurCerisier.getChildren().add(mesCerises);
	}

private void imgPoire(StackPane conteneurPoirier) {
	
	GridPane mesPoires = new GridPane();
	mesPoires.setPadding(new Insets (60,0,0,75));
	
	
	for (int row = 0; row < 2; row++) {
	    for (int col = 0; col < 5; col++) {
	    	ImageView vuePoire = new ImageView(Fruit.POIRE.image);
	    	vuePoire.setFitWidth(50);
	    	vuePoire.setFitHeight(50);
	    	mesPoires.add(vuePoire, col, row);
	    }
	}

	conteneurPoirier.getChildren().add(mesPoires);
}

private void imgPrune(StackPane conteneurPrunier) {
	
	GridPane mesPrunes = new GridPane();
	mesPrunes.setPadding(new Insets (60,0,0,75));
	
	
	for (int row = 0; row < 2; row++) {
	    for (int col = 0; col < 5; col++) {
	    	ImageView vuePrune = new ImageView(Fruit.PRUNE.image);
	    	vuePrune.setFitWidth(50);
	    	vuePrune.setFitHeight(50);
	    	mesPrunes.add(vuePrune, col, row);
	    }
	}

	conteneurPrunier.getChildren().add(mesPrunes);
}


    public static void main(String[] args) {
        launch(args);
    }
}
