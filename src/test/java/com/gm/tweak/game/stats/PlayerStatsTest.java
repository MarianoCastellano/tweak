package com.gm.tweak.game.stats;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.game.Board;
import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;
import com.gm.tweak.domain.game.Player;
import com.gm.tweak.domain.game.PlayerId;
import com.gm.tweak.domain.game.Word;
import com.gm.tweak.domain.game.stats.PlayerStats;

public class PlayerStatsTest {

	private Player playerCreator;
	private Player playerDiviner;

	@Test
	public void playersStatsUpdatedWhenDrawIsDivined() {

		givenAPlayerCreator();
		andADivinerPlayer();

		whenDivinerGuessTheDrawingOfGameCreator();

		thenPlayerStatsAreUpdated();

	}

	private void thenPlayerStatsAreUpdated() {
		Assert.assertEquals(new Long(1), playerDiviner.getDivinedDrawingsAmount());
		Assert.assertEquals(new Long(1), playerCreator.getMadeDrawingsAmount());
		Assert.assertEquals(new Long(1), playerCreator.getDrawingsThatWereGuessToMe());
	}

	private void whenDivinerGuessTheDrawingOfGameCreator() {
		Game game = new Game(new GameId("1"),
				new Drawing(playerCreator.getPlayerId(), new Board(new byte[1]), new Word("Stone")), playerCreator);
		game.tryWord(playerDiviner, new Word("Stone"));
	}

	private void andADivinerPlayer() {
		this.playerDiviner = new Player(new PlayerId("2"), new PlayerStats(0L, 0L, 0L));
	}

	private void givenAPlayerCreator() {
		this.playerCreator = new Player(new PlayerId("1"), new PlayerStats(0L, 0L, 0L));
	}
}
