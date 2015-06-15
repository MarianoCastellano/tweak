package com.gm.tweak.game;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.game.Board;
import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;
import com.gm.tweak.domain.game.Player;
import com.gm.tweak.domain.game.PlayerId;
import com.gm.tweak.domain.game.Word;

public class GameTest {

	@Test
	public void tryWordShouldAddCoinsToPlayers() throws Exception {

		PlayerId artistId = new PlayerId("1");
		Player artist = new Player(artistId);

		PlayerId divinerId = new PlayerId("2");
		Player diviner = new Player(divinerId);

		Game game = new Game(new GameId("1"), new Drawing(artistId, new Board(new byte[1]), new Word("Stone")), artist);

		game.tryWord(diviner, new Word("Stone"));

		Assert.assertEquals(new Long(31), diviner.getCoins());
		Assert.assertEquals(new Long(31), artist.getCoins());
	}
}
