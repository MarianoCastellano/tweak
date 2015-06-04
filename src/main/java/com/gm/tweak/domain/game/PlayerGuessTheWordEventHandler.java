package com.gm.tweak.domain.game;

public class PlayerGuessTheWordEventHandler {

	public void handle(PlayerGuessTheDrawingEvent domainEvent) {

		addCoinsToDivinerPlayer(domainEvent);
		// addStatsToPlayer();
		// addAchievementToWinner();
	}

	private void addCoinsToDivinerPlayer(PlayerGuessTheDrawingEvent domainEvent) {
		Long drawingValue = domainEvent.getGame().getDrawing().getValue();
		domainEvent.getPlayerDiviner().addCoins(drawingValue);
	}

}
