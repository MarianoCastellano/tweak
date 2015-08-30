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
import com.gm.tweak.domain.game.factory.GameBuilder;
import com.gm.tweak.domain.user.PlayerStats;
import com.gm.tweak.domain.user.event.PlayerWonDomainEvent;
import com.gm.tweak.exception.GameCreationException;

public class GameTest {

	@Test
	public void tryWordShouldAddCoinsToPlayers() throws Exception {

		PlayerId artistId = new PlayerId("1");
		Player artist = givenAPlayerArtist(artistId);

		Player diviner = givenAPlayerDiviner();

		Game game = new GameBuilder().withGameId(new GameId("1"))
				.withDrawing(new Drawing(artistId, new Board(new byte[1]), new Word("Stone")))
				.withPlayerCreator(artist).withDomainEvent(new PlayerWonDomainEvent()).build();

		game.tryWord(diviner, new Word("Stone"));

		Assert.assertEquals(new Long(31), diviner.getCoins(), 0.1);
		Assert.assertEquals(new Long(31), artist.getCoins(), 0.1);
	}

	@Test
	public void winTenGamesShouldAddAchievementToDiviner() throws Exception {

		Player diviner = givenAPlayerDiviner();

		PlayerId artistId = new PlayerId("1");
		Player artist = givenAPlayerArtist(artistId);

		playerDivinerDivineAmountOfGames(diviner, artistId, artist, 50);

		Assert.assertEquals(3, diviner.getAchievements().size());

	}

	private void playerDivinerDivineAmountOfGames(Player diviner, PlayerId artistId, Player artist,
			int gamesAmount) throws GameCreationException {
		for (int i = 0; i < gamesAmount; i++) {
			Game game = new GameBuilder().withGameId(new GameId(String.valueOf(i)))
					.withDrawing(new Drawing(artistId, new Board(new byte[1]), new Word("Stone" + i)))
					.withPlayerCreator(artist).withDomainEvent(new PlayerWonDomainEvent()).build();
			game.tryWord(diviner, new Word("Stone" + i));
		}
	}

	private Player givenAPlayerArtist(PlayerId artistId) {
		return new Player(artistId, new PlayerStats(0L, 0L, 0L));
	}

	private Player givenAPlayerDiviner() {
		PlayerId divinerId = new PlayerId("2");
		Player diviner = givenAPlayerArtist(divinerId);
		return diviner;
	}
}
