package comp1110.ass1;

import java.util.Random;

/**
 * The objective of the game is represented as two arrays of pairs of icons,
 * one representing the 'connected' pairs (those icons that MUST be connected),
 * one representing the 'disconnected' pairs (those icons that must NOT be
 * connected).
 */
public class Objective {
  private int problemNumber;           // the number from the original game (1 .. 48)
  private Icon[][] connectedPairs;     // icons that MUST be connected
  private Icon[][] disconnectedPairs;  // icons that must NOT be connected

  /**
   * The objective is constructed using string encodings of connected and
   * disconnected icon pairs.
   *
   * @param connected     A string representing the pairs of icons that must
   *                      be connected.
   * @param disconnected  A string represnting the pairs of icons that must
   *                      NOT be connected.
   * @param problemNumber The problem number from the original board game,
   *                      a value from 1 .. 48.
   */
  public Objective(String connected, String disconnected, int problemNumber) {
    assert problemNumber >= 1 && problemNumber <= 48;
    this.connectedPairs = iconPairsFromString(connected);
    this.disconnectedPairs = iconPairsFromString(disconnected);
    this.problemNumber = problemNumber;
  }

  /**
   * Choose a new objective, given a difficulty level.  The method should select a randomized
   * objective from the 48 pre-defined solutions, being sure to select an objective with the correct
   * level of difficulty.
   * <p>
   * See the comments above the declaration of the OBJECTIVES array, below.
   * <p>
   * So, for example, if the difficulty is 0 (starter), then this function should use a randomized
   * index between 0 and 11 (inclusive) to return an objective from the OBJECTIVES array that is
   * level 0 difficulty.  On the other hand, if the difficulty is 3 (master), then this function
   * should use a randomized index between 36 and 47 (inclusive) to return an objective from the
   * OBJECTIVES array that is level 3 difficulty.
   * <p>
   * The original code below simply returns OBJECTIVES[0], which neither respects the difficulty
   * (it always returns a level 0 objective), nor is it randomized (it always returns the same
   * objective).
   *
   * @param difficulty The difficulty of the game (0 - starter, 1 - junior, 2 - expert, 3 - master)
   * @return An objective at the appropriate level of difficulty.
   */

  public static Objective newObjective(int difficulty) {
  	assert difficulty >= 0 && difficulty <= 3;
    Random rnd = new Random();
    switch (difficulty) {
      case 0:
        return OBJECTIVES[rnd.nextInt(12)];
      case 1:
        return OBJECTIVES[12 + rnd.nextInt(12)];
      case 2:
        return OBJECTIVES[24 + rnd.nextInt(12)];
      case 3:

        return OBJECTIVES[36 + rnd.nextInt(12)];


    }
    return null;
  }

  /**
   * @return the list of connected pairs of icons
   */
  public Icon[][] getConnectedPairs() {
    return connectedPairs;
  }

  /**
   * @return the list of disconnected pairs of icons
   */
  public Icon[][] getDisconnectedPairs() {
    return disconnectedPairs;
  }

  /**
   * @return the problem number for this objective
   */
  public int getProblemNumber() {
    return problemNumber;
  }

  /**
   * Take as input a String representing pairs of icons, and use that information
   * to create an array of arrays of Icons.
   * <p>
   * The string should be non-null and have an even number of characters.
   * Characters within the string are arranged in pairs, representing pairs
   * of icons according to the encoding given in the Icon class.
   * <p>
   * For example, the string "QV" represents a pair 'FROG', 'HAT'.  In
   * that case the function should return an array of length one (one pair)
   * and that array element should be an array of Icon of length two
   * (the pair), and those elements should be 'FROG' and 'HAT':
   * <p>
   * -->[+]                       Type: Icon[][], length 1
   *     |
   *     +->[FROG, HAT]           Type: Icon[],   length 2
   * <p>
   * Likewise, the string "YIYU" represents two pairs, 'SKELETON', 'CAT' and
   * 'SKELETON', 'BROOM'.  In that case the function should return an array of
   * length two (two pairs) and each of the two array elements should be an
   * array of Icon of length two (each pair), and those elements should be
   * SKELETON', 'CAT' and 'SKELETON', 'BROOM':
   * <p>
   * -->[+, +]                        Type: Icon[][], length 2
   *     |  |
   *     |  +->[SKELETON, CAT]        Type: Icon[],   length 2
   *     +---->[SKELETON, BROOM]      Type: Icon[],   length 2
   *
   * @param pairEnconding A string representing encodings of pairs of icons
   * @return An array of pairs of icons
   */
  public static Icon[][] iconPairsFromString(String pairEnconding) {

  	int pair = pairEnconding.length() / 2;
  	Icon [][] temp = new Icon[pair][2];
	for(int i = 0; i < pairEnconding.length(); i++ ){
		if(i % 2 == 0) {
			switch(pairEnconding.charAt(i)) {
				case 'I':
					temp[i/2][0] = Icon.CAT;
					break;
				case 'Q':
					temp[i/2][0] = Icon.FROG;
					break;
				case 'R':
					temp[i/2][0] = Icon.WITCH;
					break;
				case 'S':
					temp[i/2][0] = Icon.BOOKS;
					break;
				case 'T':
					temp[i/2][0] = Icon.MUSHROOMS;
					break;
				case 'U':
					temp[i/2][0] = Icon.BROOM;
					break;
				case 'V':
					temp[i/2][0] = Icon.HAT;
					break;
				case 'W':
					temp[i/2][0] = Icon.PUMPKIN;
					break;
				case 'X':
					temp[i/2][0] = Icon.RAVEN;
					break;
				case 'Y':
					temp[i/2][0] = Icon.SKELETON;
					break;
				case 'Z':
					temp[i/2][0] = Icon.CAULDRON;
					break;


			}
		}
		else {
			switch(pairEnconding.charAt(i)) {
				case 'I':
					temp[i/2][1] = Icon.CAT;
					break;
				case 'Q':
					temp[i/2][1] = Icon.FROG;
					break;
				case 'R':
					temp[i/2][1] = Icon.WITCH;
					break;
				case 'S':
					temp[i/2][1] = Icon.BOOKS;
					break;
				case 'T':
					temp[i/2][1] = Icon.MUSHROOMS;
					break;
				case 'U':
					temp[i/2][1] = Icon.BROOM;
					break;
				case 'V':
					temp[i/2][1] = Icon.HAT;
					break;
				case 'W':
					temp[i/2][1] = Icon.PUMPKIN;
					break;
				case 'X':
					temp[i/2][1] = Icon.RAVEN;
					break;
				case 'Y':
					temp[i/2][1] = Icon.SKELETON;
					break;
				case 'Z':
					temp[i/2][1] = Icon.CAULDRON;
					break;

			}

		}
	}



  	return temp;// TODO Task 6
  }


  /*
   * This array defines a set of 48 pre-defined puzzle objectives.
   *
   * There are four categories of objective, according to four difficulty levels, with
   * 12 objectives per difficulty level, organized within the array as follows:
   *
   * Starter: 0-11
   * Junior: 12-23
   * Expert: 24-35
   * Master: 36-47
   *
   * Each objective is encoded in terms of a string representing necessary paths, a string
   * representing prohibited paths, and an objective problemNumber corresponding to the
   * objective problem number used in the original game.
   *
   * I - cat
   * Q - frog
   * R - witch
   * S - books
   * T - mushroom
   * U - broom
   * V - hat
   * W - pumpkin
   * X - raven
   * Y - skeleton
   * Z - cauldron
   */
  static Objective[] OBJECTIVES = {
          new Objective("RW", "", 1),
          new Objective("QV", "", 2),
          new Objective("YIYU", "", 3),
          new Objective("QXQW", "", 4),
          new Objective("RWRZ", "", 5),
          new Objective("TITU", "", 6),
          new Objective("RXXS", "", 7),
          new Objective("VIVUUYIY", "", 8),
          new Objective("RSQX", "", 9),
          new Objective("UZVQ", "", 10),
          new Objective("RZRWRT", "", 11),
          new Objective("QUUVVT", "", 12),
          new Objective("TU", "VU", 13),
          new Objective("QX", "IQ", 14),
          new Objective("IYRV", "IR", 15),
          new Objective("VSVQUT", "UV", 16),
          new Objective("RWXZ", "RZXW", 17),
          new Objective("IVIQUY", "IU", 18),
          new Objective("XRVTVS", "XV", 19),
          new Objective("IQUQQW", "VIVU", 20),
          new Objective("", "VQVSVTVWVZRQRSRTRWRZ", 21),
          new Objective("VYUZ", "IQIS", 22),
          new Objective("RQRXRTRV", "", 23),
          new Objective("IQITIWIY", "UI", 24),
          new Objective("UQURUSUVUWUYUXUZ", "", 25),
          new Objective("VSUY", "ITIW", 26),
          new Objective("VXVYVZVQVSVU", "VW", 27),
          new Objective("QTQYVTVY", "QUQWQIQSVUVWVIVS", 28),
          new Objective("VSVWQYQUQX", "QV", 29),
          new Objective("ISIUIYIZ", "ITIVIW", 30),
          new Objective("UYURUTIWIZ", "QYQRQT", 31),
          new Objective("QSQTVSVTIWIZUWUZ", "IQIVUQUV", 32),
          new Objective("ISIWIZQTRTVT", "IQIRIV", 33),
          new Objective("RQRYRVRSRXRWRZ", "", 34),
          new Objective("RXITIYUW", "QRRIUTUY", 35),
          new Objective("ITIWIVIUIY", "QSQZXSXZIQIX", 36),
          new Objective("VQVSITRZ", "VTIZ", 37),
          new Objective("", "UIUWUZUVUTQTQVQIQWQZ", 38),
          new Objective("RVISITIZUSUTUZXY", "IVUVIYUY", 39),
          new Objective("QIQYQTVIVYVT", "QSQWVSVWUIUTUY", 40),
          new Objective("ITIZQR", "IRISIXIV", 41),
          new Objective("", "QSQZQYQWQTQIVZVSVYVWVTVIUZUSUYUWUTUI", 42),
          new Objective("USRZVX", "UTRTVTVSVZ", 43),
          new Objective("UYUZIYIZVWVQVTVS", "IVUV", 44),
          new Objective("USISVTVX", "UVIVUQURIQIR", 45),
          new Objective("VSUTUYIQIW", "ITIYUS", 46),
          new Objective("XSXZVT", "XQXRXW", 47),
          new Objective("QSQTQVQWQY", "ISITIVIWIY", 48),
  };
}
