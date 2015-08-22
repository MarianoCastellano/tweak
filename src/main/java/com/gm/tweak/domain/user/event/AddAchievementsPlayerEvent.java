package com.gm.tweak.domain.user.event;

import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.Player;
import com.gm.tweak.domain.user.achievements.Achievement;

public class AddAchievementsPlayerEvent implements PlayerEvent {

	@Override
	public void update(Game game, Player diviner) {

		if (diviner.getDivinedDrawingsAmount() == 10) {
			diviner.addAchievement(new Achievement("Pequeno Adivinador", "Adivinar 10 Dibujos"));
		}

		if (diviner.getDivinedDrawingsAmount() == 25) {
			diviner.addAchievement(new Achievement("Pequeno adivinador con Sombrero", "Adivinar 25 Dibujos"));
		}

		if (diviner.getDivinedDrawingsAmount() == 50) {
			diviner.addAchievement(new Achievement("Joven Adivinador", "Adivinar 50 Dibujos"));
		}
	}

}
