/*
 *  Copyright 2016 riddles.io (developers@riddles.io)
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 *
 *      For the full copyright and license information, please view the LICENSE
 *      file that was distributed with this source code.
 */

package bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import moves.Move;
import moves.MoveType;

/**
 * BotStarter class
 * 
 * This class is where the main logic should be. Implement getMove() to
 * return something better than random moves.
 * 
 * @author Jim van Eeden <jim@riddles.io>
 */

public class BotStarter {

	private Random random;

	public BotStarter() {
		this.random = new Random();
	}
	
	/**
	 * Returns a random amount of random moves
	 * @param state current state of the bot
	 * @return a list of moves to execute
	 */
	public Move getMove(BotState state) {
		List<MoveType> allMoves = Collections.unmodifiableList(Arrays.asList(MoveType.values()));
		MoveType move = null;

        ArrayList<MoveType> moves = new ArrayList<>();
		while (move != MoveType.DROP) {
		    move = allMoves.get(this.random.nextInt(allMoves.size()));
		    moves.add(move);
        }
		
		return new Move(moves);
	}
	
	public static void main(String[] args) {
		BotParser parser = new BotParser(new BotStarter());
		parser.run();
	}
}
