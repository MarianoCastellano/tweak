package com.gm.tweak.game;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.game.BlankDrawing;
import com.gm.tweak.domain.game.Board;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;
import com.gm.tweak.domain.game.Player;
import com.gm.tweak.domain.game.PlayerId;
import com.gm.tweak.domain.game.Word;
import com.gm.tweak.domain.game.factory.GameBuilder;

public class GameTest {

	@Test
	public void playerGuessTheWord() throws Exception {

		Game game = createDefaultGame();

		String artistId = "1";
		String divinerId = "2";

		Player artist = new Player(new PlayerId(artistId));
		Player diviner = new Player(new PlayerId(divinerId));

		game.draw(artist, new Board());
		Boolean divined = game.tryWord(diviner, new Word("Stone"));

		Assert.assertTrue(divined);
		Assert.assertEquals(diviner, game.getCurrentDiviner());
		Assert.assertEquals(new Long(11), diviner.getCoins());
		Assert.assertEquals(new Long(11), game.getArtist().getCoins());
		
		Assert.assertEquals(artist, game.getArtist());
		Assert.assertEquals(diviner, game.getCurrentDiviner());

	}

	@Test(expected = Exception.class)
	public void playerCantTryWordIfNoArtistYet() throws Exception {

		Game game = createDefaultGame();

		String artistId = "1";

		Player diviner = new Player(new PlayerId(artistId));

		game.tryWord(diviner, new Word("Stone"));

	}

	private Game createDefaultGame() {
		return new GameBuilder().withGameId(new GameId("1")).withWord(new Word("Stone")).withDrawing(new BlankDrawing()).build();
	}
}
