package chess
package variant

import chess.format.EpdFen

case object Chess960
    extends Variant(
      id = Variant.Id(2),
      key = Variant.LilaKey("chess960"),
      uciKey = Variant.UciKey("chess"),
      name = "Chess960",
      shortName = "960",
      title = "Starting position of the home rank pieces is randomized.",
      standardInitialPosition = false
    ):

  override def validMoves(situation: Situation): List[Move] =
    Standard.validMoves(situation)

  def pieces = pieces(scala.util.Random.nextInt(960))

  def pieces(position: Int) =
    Variant.symmetricRank {
      positions(position) flatMap Role.allByForsyth.get
    }

  def positionNumber(fen: EpdFen): Option[Int] =
    fen.value split ' ' match
      case Array(board, "w", "KQkq", "-", "0", "1") =>
        board split '/' match
          case Array(rank8, "pppppppp", "8", "8", "8", "8", "PPPPPPPP", rank1) =>
            positionsMap get rank8 filter { _ =>
              rank1 zip rank8 forall { case (r1, r8) =>
                r1 != r8 && r1.toLower == r8
              }
            }
          case _ => None
      case _ => None

  private val positions = Array(
    "bbqnnrkr",
    "bqnbnrkr",
    "bqnnrbkr",
    "bqnnrkrb",
    "qbbnnrkr",
    "qnbbnrkr",
    "qnbnrbkr",
    "qnbnrkrb",
    "qbnnbrkr",
    "qnnbbrkr",
    "qnnrbbkr",
    "qnnrbkrb",
    "qbnnrkbr",
    "qnnbrkbr",
    "qnnrkbbr",
    "qnnrkrbb",
    "bbnqnrkr",
    "bnqbnrkr",
    "bnqnrbkr",
    "bnqnrkrb",
    "nbbqnrkr",
    "nqbbnrkr",
    "nqbnrbkr",
    "nqbnrkrb",
    "nbqnbrkr",
    "nqnbbrkr",
    "nqnrbbkr",
    "nqnrbkrb",
    "nbqnrkbr",
    "nqnbrkbr",
    "nqnrkbbr",
    "nqnrkrbb",
    "bbnnqrkr",
    "bnnbqrkr",
    "bnnqrbkr",
    "bnnqrkrb",
    "nbbnqrkr",
    "nnbbqrkr",
    "nnbqrbkr",
    "nnbqrkrb",
    "nbnqbrkr",
    "nnqbbrkr",
    "nnqrbbkr",
    "nnqrbkrb",
    "nbnqrkbr",
    "nnqbrkbr",
    "nnqrkbbr",
    "nnqrkrbb",
    "bbnnrqkr",
    "bnnbrqkr",
    "bnnrqbkr",
    "bnnrqkrb",
    "nbbnrqkr",
    "nnbbrqkr",
    "nnbrqbkr",
    "nnbrqkrb",
    "nbnrbqkr",
    "nnrbbqkr",
    "nnrqbbkr",
    "nnrqbkrb",
    "nbnrqkbr",
    "nnrbqkbr",
    "nnrqkbbr",
    "nnrqkrbb",
    "bbnnrkqr",
    "bnnbrkqr",
    "bnnrkbqr",
    "bnnrkqrb",
    "nbbnrkqr",
    "nnbbrkqr",
    "nnbrkbqr",
    "nnbrkqrb",
    "nbnrbkqr",
    "nnrbbkqr",
    "nnrkbbqr",
    "nnrkbqrb",
    "nbnrkqbr",
    "nnrbkqbr",
    "nnrkqbbr",
    "nnrkqrbb",
    "bbnnrkrq",
    "bnnbrkrq",
    "bnnrkbrq",
    "bnnrkrqb",
    "nbbnrkrq",
    "nnbbrkrq",
    "nnbrkbrq",
    "nnbrkrqb",
    "nbnrbkrq",
    "nnrbbkrq",
    "nnrkbbrq",
    "nnrkbrqb",
    "nbnrkrbq",
    "nnrbkrbq",
    "nnrkrbbq",
    "nnrkrqbb",
    "bbqnrnkr",
    "bqnbrnkr",
    "bqnrnbkr",
    "bqnrnkrb",
    "qbbnrnkr",
    "qnbbrnkr",
    "qnbrnbkr",
    "qnbrnkrb",
    "qbnrbnkr",
    "qnrbbnkr",
    "qnrnbbkr",
    "qnrnbkrb",
    "qbnrnkbr",
    "qnrbnkbr",
    "qnrnkbbr",
    "qnrnkrbb",
    "bbnqrnkr",
    "bnqbrnkr",
    "bnqrnbkr",
    "bnqrnkrb",
    "nbbqrnkr",
    "nqbbrnkr",
    "nqbrnbkr",
    "nqbrnkrb",
    "nbqrbnkr",
    "nqrbbnkr",
    "nqrnbbkr",
    "nqrnbkrb",
    "nbqrnkbr",
    "nqrbnkbr",
    "nqrnkbbr",
    "nqrnkrbb",
    "bbnrqnkr",
    "bnrbqnkr",
    "bnrqnbkr",
    "bnrqnkrb",
    "nbbrqnkr",
    "nrbbqnkr",
    "nrbqnbkr",
    "nrbqnkrb",
    "nbrqbnkr",
    "nrqbbnkr",
    "nrqnbbkr",
    "nrqnbkrb",
    "nbrqnkbr",
    "nrqbnkbr",
    "nrqnkbbr",
    "nrqnkrbb",
    "bbnrnqkr",
    "bnrbnqkr",
    "bnrnqbkr",
    "bnrnqkrb",
    "nbbrnqkr",
    "nrbbnqkr",
    "nrbnqbkr",
    "nrbnqkrb",
    "nbrnbqkr",
    "nrnbbqkr",
    "nrnqbbkr",
    "nrnqbkrb",
    "nbrnqkbr",
    "nrnbqkbr",
    "nrnqkbbr",
    "nrnqkrbb",
    "bbnrnkqr",
    "bnrbnkqr",
    "bnrnkbqr",
    "bnrnkqrb",
    "nbbrnkqr",
    "nrbbnkqr",
    "nrbnkbqr",
    "nrbnkqrb",
    "nbrnbkqr",
    "nrnbbkqr",
    "nrnkbbqr",
    "nrnkbqrb",
    "nbrnkqbr",
    "nrnbkqbr",
    "nrnkqbbr",
    "nrnkqrbb",
    "bbnrnkrq",
    "bnrbnkrq",
    "bnrnkbrq",
    "bnrnkrqb",
    "nbbrnkrq",
    "nrbbnkrq",
    "nrbnkbrq",
    "nrbnkrqb",
    "nbrnbkrq",
    "nrnbbkrq",
    "nrnkbbrq",
    "nrnkbrqb",
    "nbrnkrbq",
    "nrnbkrbq",
    "nrnkrbbq",
    "nrnkrqbb",
    "bbqnrknr",
    "bqnbrknr",
    "bqnrkbnr",
    "bqnrknrb",
    "qbbnrknr",
    "qnbbrknr",
    "qnbrkbnr",
    "qnbrknrb",
    "qbnrbknr",
    "qnrbbknr",
    "qnrkbbnr",
    "qnrkbnrb",
    "qbnrknbr",
    "qnrbknbr",
    "qnrknbbr",
    "qnrknrbb",
    "bbnqrknr",
    "bnqbrknr",
    "bnqrkbnr",
    "bnqrknrb",
    "nbbqrknr",
    "nqbbrknr",
    "nqbrkbnr",
    "nqbrknrb",
    "nbqrbknr",
    "nqrbbknr",
    "nqrkbbnr",
    "nqrkbnrb",
    "nbqrknbr",
    "nqrbknbr",
    "nqrknbbr",
    "nqrknrbb",
    "bbnrqknr",
    "bnrbqknr",
    "bnrqkbnr",
    "bnrqknrb",
    "nbbrqknr",
    "nrbbqknr",
    "nrbqkbnr",
    "nrbqknrb",
    "nbrqbknr",
    "nrqbbknr",
    "nrqkbbnr",
    "nrqkbnrb",
    "nbrqknbr",
    "nrqbknbr",
    "nrqknbbr",
    "nrqknrbb",
    "bbnrkqnr",
    "bnrbkqnr",
    "bnrkqbnr",
    "bnrkqnrb",
    "nbbrkqnr",
    "nrbbkqnr",
    "nrbkqbnr",
    "nrbkqnrb",
    "nbrkbqnr",
    "nrkbbqnr",
    "nrkqbbnr",
    "nrkqbnrb",
    "nbrkqnbr",
    "nrkbqnbr",
    "nrkqnbbr",
    "nrkqnrbb",
    "bbnrknqr",
    "bnrbknqr",
    "bnrknbqr",
    "bnrknqrb",
    "nbbrknqr",
    "nrbbknqr",
    "nrbknbqr",
    "nrbknqrb",
    "nbrkbnqr",
    "nrkbbnqr",
    "nrknbbqr",
    "nrknbqrb",
    "nbrknqbr",
    "nrkbnqbr",
    "nrknqbbr",
    "nrknqrbb",
    "bbnrknrq",
    "bnrbknrq",
    "bnrknbrq",
    "bnrknrqb",
    "nbbrknrq",
    "nrbbknrq",
    "nrbknbrq",
    "nrbknrqb",
    "nbrkbnrq",
    "nrkbbnrq",
    "nrknbbrq",
    "nrknbrqb",
    "nbrknrbq",
    "nrkbnrbq",
    "nrknrbbq",
    "nrknrqbb",
    "bbqnrkrn",
    "bqnbrkrn",
    "bqnrkbrn",
    "bqnrkrnb",
    "qbbnrkrn",
    "qnbbrkrn",
    "qnbrkbrn",
    "qnbrkrnb",
    "qbnrbkrn",
    "qnrbbkrn",
    "qnrkbbrn",
    "qnrkbrnb",
    "qbnrkrbn",
    "qnrbkrbn",
    "qnrkrbbn",
    "qnrkrnbb",
    "bbnqrkrn",
    "bnqbrkrn",
    "bnqrkbrn",
    "bnqrkrnb",
    "nbbqrkrn",
    "nqbbrkrn",
    "nqbrkbrn",
    "nqbrkrnb",
    "nbqrbkrn",
    "nqrbbkrn",
    "nqrkbbrn",
    "nqrkbrnb",
    "nbqrkrbn",
    "nqrbkrbn",
    "nqrkrbbn",
    "nqrkrnbb",
    "bbnrqkrn",
    "bnrbqkrn",
    "bnrqkbrn",
    "bnrqkrnb",
    "nbbrqkrn",
    "nrbbqkrn",
    "nrbqkbrn",
    "nrbqkrnb",
    "nbrqbkrn",
    "nrqbbkrn",
    "nrqkbbrn",
    "nrqkbrnb",
    "nbrqkrbn",
    "nrqbkrbn",
    "nrqkrbbn",
    "nrqkrnbb",
    "bbnrkqrn",
    "bnrbkqrn",
    "bnrkqbrn",
    "bnrkqrnb",
    "nbbrkqrn",
    "nrbbkqrn",
    "nrbkqbrn",
    "nrbkqrnb",
    "nbrkbqrn",
    "nrkbbqrn",
    "nrkqbbrn",
    "nrkqbrnb",
    "nbrkqrbn",
    "nrkbqrbn",
    "nrkqrbbn",
    "nrkqrnbb",
    "bbnrkrqn",
    "bnrbkrqn",
    "bnrkrbqn",
    "bnrkrqnb",
    "nbbrkrqn",
    "nrbbkrqn",
    "nrbkrbqn",
    "nrbkrqnb",
    "nbrkbrqn",
    "nrkbbrqn",
    "nrkrbbqn",
    "nrkrbqnb",
    "nbrkrqbn",
    "nrkbrqbn",
    "nrkrqbbn",
    "nrkrqnbb",
    "bbnrkrnq",
    "bnrbkrnq",
    "bnrkrbnq",
    "bnrkrnqb",
    "nbbrkrnq",
    "nrbbkrnq",
    "nrbkrbnq",
    "nrbkrnqb",
    "nbrkbrnq",
    "nrkbbrnq",
    "nrkrbbnq",
    "nrkrbnqb",
    "nbrkrnbq",
    "nrkbrnbq",
    "nrkrnbbq",
    "nrkrnqbb",
    "bbqrnnkr",
    "bqrbnnkr",
    "bqrnnbkr",
    "bqrnnkrb",
    "qbbrnnkr",
    "qrbbnnkr",
    "qrbnnbkr",
    "qrbnnkrb",
    "qbrnbnkr",
    "qrnbbnkr",
    "qrnnbbkr",
    "qrnnbkrb",
    "qbrnnkbr",
    "qrnbnkbr",
    "qrnnkbbr",
    "qrnnkrbb",
    "bbrqnnkr",
    "brqbnnkr",
    "brqnnbkr",
    "brqnnkrb",
    "rbbqnnkr",
    "rqbbnnkr",
    "rqbnnbkr",
    "rqbnnkrb",
    "rbqnbnkr",
    "rqnbbnkr",
    "rqnnbbkr",
    "rqnnbkrb",
    "rbqnnkbr",
    "rqnbnkbr",
    "rqnnkbbr",
    "rqnnkrbb",
    "bbrnqnkr",
    "brnbqnkr",
    "brnqnbkr",
    "brnqnkrb",
    "rbbnqnkr",
    "rnbbqnkr",
    "rnbqnbkr",
    "rnbqnkrb",
    "rbnqbnkr",
    "rnqbbnkr",
    "rnqnbbkr",
    "rnqnbkrb",
    "rbnqnkbr",
    "rnqbnkbr",
    "rnqnkbbr",
    "rnqnkrbb",
    "bbrnnqkr",
    "brnbnqkr",
    "brnnqbkr",
    "brnnqkrb",
    "rbbnnqkr",
    "rnbbnqkr",
    "rnbnqbkr",
    "rnbnqkrb",
    "rbnnbqkr",
    "rnnbbqkr",
    "rnnqbbkr",
    "rnnqbkrb",
    "rbnnqkbr",
    "rnnbqkbr",
    "rnnqkbbr",
    "rnnqkrbb",
    "bbrnnkqr",
    "brnbnkqr",
    "brnnkbqr",
    "brnnkqrb",
    "rbbnnkqr",
    "rnbbnkqr",
    "rnbnkbqr",
    "rnbnkqrb",
    "rbnnbkqr",
    "rnnbbkqr",
    "rnnkbbqr",
    "rnnkbqrb",
    "rbnnkqbr",
    "rnnbkqbr",
    "rnnkqbbr",
    "rnnkqrbb",
    "bbrnnkrq",
    "brnbnkrq",
    "brnnkbrq",
    "brnnkrqb",
    "rbbnnkrq",
    "rnbbnkrq",
    "rnbnkbrq",
    "rnbnkrqb",
    "rbnnbkrq",
    "rnnbbkrq",
    "rnnkbbrq",
    "rnnkbrqb",
    "rbnnkrbq",
    "rnnbkrbq",
    "rnnkrbbq",
    "rnnkrqbb",
    "bbqrnknr",
    "bqrbnknr",
    "bqrnkbnr",
    "bqrnknrb",
    "qbbrnknr",
    "qrbbnknr",
    "qrbnkbnr",
    "qrbnknrb",
    "qbrnbknr",
    "qrnbbknr",
    "qrnkbbnr",
    "qrnkbnrb",
    "qbrnknbr",
    "qrnbknbr",
    "qrnknbbr",
    "qrnknrbb",
    "bbrqnknr",
    "brqbnknr",
    "brqnkbnr",
    "brqnknrb",
    "rbbqnknr",
    "rqbbnknr",
    "rqbnkbnr",
    "rqbnknrb",
    "rbqnbknr",
    "rqnbbknr",
    "rqnkbbnr",
    "rqnkbnrb",
    "rbqnknbr",
    "rqnbknbr",
    "rqnknbbr",
    "rqnknrbb",
    "bbrnqknr",
    "brnbqknr",
    "brnqkbnr",
    "brnqknrb",
    "rbbnqknr",
    "rnbbqknr",
    "rnbqkbnr",
    "rnbqknrb",
    "rbnqbknr",
    "rnqbbknr",
    "rnqkbbnr",
    "rnqkbnrb",
    "rbnqknbr",
    "rnqbknbr",
    "rnqknbbr",
    "rnqknrbb",
    "bbrnkqnr",
    "brnbkqnr",
    "brnkqbnr",
    "brnkqnrb",
    "rbbnkqnr",
    "rnbbkqnr",
    "rnbkqbnr",
    "rnbkqnrb",
    "rbnkbqnr",
    "rnkbbqnr",
    "rnkqbbnr",
    "rnkqbnrb",
    "rbnkqnbr",
    "rnkbqnbr",
    "rnkqnbbr",
    "rnkqnrbb",
    "bbrnknqr",
    "brnbknqr",
    "brnknbqr",
    "brnknqrb",
    "rbbnknqr",
    "rnbbknqr",
    "rnbknbqr",
    "rnbknqrb",
    "rbnkbnqr",
    "rnkbbnqr",
    "rnknbbqr",
    "rnknbqrb",
    "rbnknqbr",
    "rnkbnqbr",
    "rnknqbbr",
    "rnknqrbb",
    "bbrnknrq",
    "brnbknrq",
    "brnknbrq",
    "brnknrqb",
    "rbbnknrq",
    "rnbbknrq",
    "rnbknbrq",
    "rnbknrqb",
    "rbnkbnrq",
    "rnkbbnrq",
    "rnknbbrq",
    "rnknbrqb",
    "rbnknrbq",
    "rnkbnrbq",
    "rnknrbbq",
    "rnknrqbb",
    "bbqrnkrn",
    "bqrbnkrn",
    "bqrnkbrn",
    "bqrnkrnb",
    "qbbrnkrn",
    "qrbbnkrn",
    "qrbnkbrn",
    "qrbnkrnb",
    "qbrnbkrn",
    "qrnbbkrn",
    "qrnkbbrn",
    "qrnkbrnb",
    "qbrnkrbn",
    "qrnbkrbn",
    "qrnkrbbn",
    "qrnkrnbb",
    "bbrqnkrn",
    "brqbnkrn",
    "brqnkbrn",
    "brqnkrnb",
    "rbbqnkrn",
    "rqbbnkrn",
    "rqbnkbrn",
    "rqbnkrnb",
    "rbqnbkrn",
    "rqnbbkrn",
    "rqnkbbrn",
    "rqnkbrnb",
    "rbqnkrbn",
    "rqnbkrbn",
    "rqnkrbbn",
    "rqnkrnbb",
    "bbrnqkrn",
    "brnbqkrn",
    "brnqkbrn",
    "brnqkrnb",
    "rbbnqkrn",
    "rnbbqkrn",
    "rnbqkbrn",
    "rnbqkrnb",
    "rbnqbkrn",
    "rnqbbkrn",
    "rnqkbbrn",
    "rnqkbrnb",
    "rbnqkrbn",
    "rnqbkrbn",
    "rnqkrbbn",
    "rnqkrnbb",
    "bbrnkqrn",
    "brnbkqrn",
    "brnkqbrn",
    "brnkqrnb",
    "rbbnkqrn",
    "rnbbkqrn",
    "rnbkqbrn",
    "rnbkqrnb",
    "rbnkbqrn",
    "rnkbbqrn",
    "rnkqbbrn",
    "rnkqbrnb",
    "rbnkqrbn",
    "rnkbqrbn",
    "rnkqrbbn",
    "rnkqrnbb",
    "bbrnkrqn",
    "brnbkrqn",
    "brnkrbqn",
    "brnkrqnb",
    "rbbnkrqn",
    "rnbbkrqn",
    "rnbkrbqn",
    "rnbkrqnb",
    "rbnkbrqn",
    "rnkbbrqn",
    "rnkrbbqn",
    "rnkrbqnb",
    "rbnkrqbn",
    "rnkbrqbn",
    "rnkrqbbn",
    "rnkrqnbb",
    "bbrnkrnq",
    "brnbkrnq",
    "brnkrbnq",
    "brnkrnqb",
    "rbbnkrnq",
    "rnbbkrnq",
    "rnbkrbnq",
    "rnbkrnqb",
    "rbnkbrnq",
    "rnkbbrnq",
    "rnkrbbnq",
    "rnkrbnqb",
    "rbnkrnbq",
    "rnkbrnbq",
    "rnkrnbbq",
    "rnkrnqbb",
    "bbqrknnr",
    "bqrbknnr",
    "bqrknbnr",
    "bqrknnrb",
    "qbbrknnr",
    "qrbbknnr",
    "qrbknbnr",
    "qrbknnrb",
    "qbrkbnnr",
    "qrkbbnnr",
    "qrknbbnr",
    "qrknbnrb",
    "qbrknnbr",
    "qrkbnnbr",
    "qrknnbbr",
    "qrknnrbb",
    "bbrqknnr",
    "brqbknnr",
    "brqknbnr",
    "brqknnrb",
    "rbbqknnr",
    "rqbbknnr",
    "rqbknbnr",
    "rqbknnrb",
    "rbqkbnnr",
    "rqkbbnnr",
    "rqknbbnr",
    "rqknbnrb",
    "rbqknnbr",
    "rqkbnnbr",
    "rqknnbbr",
    "rqknnrbb",
    "bbrkqnnr",
    "brkbqnnr",
    "brkqnbnr",
    "brkqnnrb",
    "rbbkqnnr",
    "rkbbqnnr",
    "rkbqnbnr",
    "rkbqnnrb",
    "rbkqbnnr",
    "rkqbbnnr",
    "rkqnbbnr",
    "rkqnbnrb",
    "rbkqnnbr",
    "rkqbnnbr",
    "rkqnnbbr",
    "rkqnnrbb",
    "bbrknqnr",
    "brkbnqnr",
    "brknqbnr",
    "brknqnrb",
    "rbbknqnr",
    "rkbbnqnr",
    "rkbnqbnr",
    "rkbnqnrb",
    "rbknbqnr",
    "rknbbqnr",
    "rknqbbnr",
    "rknqbnrb",
    "rbknqnbr",
    "rknbqnbr",
    "rknqnbbr",
    "rknqnrbb",
    "bbrknnqr",
    "brkbnnqr",
    "brknnbqr",
    "brknnqrb",
    "rbbknnqr",
    "rkbbnnqr",
    "rkbnnbqr",
    "rkbnnqrb",
    "rbknbnqr",
    "rknbbnqr",
    "rknnbbqr",
    "rknnbqrb",
    "rbknnqbr",
    "rknbnqbr",
    "rknnqbbr",
    "rknnqrbb",
    "bbrknnrq",
    "brkbnnrq",
    "brknnbrq",
    "brknnrqb",
    "rbbknnrq",
    "rkbbnnrq",
    "rkbnnbrq",
    "rkbnnrqb",
    "rbknbnrq",
    "rknbbnrq",
    "rknnbbrq",
    "rknnbrqb",
    "rbknnrbq",
    "rknbnrbq",
    "rknnrbbq",
    "rknnrqbb",
    "bbqrknrn",
    "bqrbknrn",
    "bqrknbrn",
    "bqrknrnb",
    "qbbrknrn",
    "qrbbknrn",
    "qrbknbrn",
    "qrbknrnb",
    "qbrkbnrn",
    "qrkbbnrn",
    "qrknbbrn",
    "qrknbrnb",
    "qbrknrbn",
    "qrkbnrbn",
    "qrknrbbn",
    "qrknrnbb",
    "bbrqknrn",
    "brqbknrn",
    "brqknbrn",
    "brqknrnb",
    "rbbqknrn",
    "rqbbknrn",
    "rqbknbrn",
    "rqbknrnb",
    "rbqkbnrn",
    "rqkbbnrn",
    "rqknbbrn",
    "rqknbrnb",
    "rbqknrbn",
    "rqkbnrbn",
    "rqknrbbn",
    "rqknrnbb",
    "bbrkqnrn",
    "brkbqnrn",
    "brkqnbrn",
    "brkqnrnb",
    "rbbkqnrn",
    "rkbbqnrn",
    "rkbqnbrn",
    "rkbqnrnb",
    "rbkqbnrn",
    "rkqbbnrn",
    "rkqnbbrn",
    "rkqnbrnb",
    "rbkqnrbn",
    "rkqbnrbn",
    "rkqnrbbn",
    "rkqnrnbb",
    "bbrknqrn",
    "brkbnqrn",
    "brknqbrn",
    "brknqrnb",
    "rbbknqrn",
    "rkbbnqrn",
    "rkbnqbrn",
    "rkbnqrnb",
    "rbknbqrn",
    "rknbbqrn",
    "rknqbbrn",
    "rknqbrnb",
    "rbknqrbn",
    "rknbqrbn",
    "rknqrbbn",
    "rknqrnbb",
    "bbrknrqn",
    "brkbnrqn",
    "brknrbqn",
    "brknrqnb",
    "rbbknrqn",
    "rkbbnrqn",
    "rkbnrbqn",
    "rkbnrqnb",
    "rbknbrqn",
    "rknbbrqn",
    "rknrbbqn",
    "rknrbqnb",
    "rbknrqbn",
    "rknbrqbn",
    "rknrqbbn",
    "rknrqnbb",
    "bbrknrnq",
    "brkbnrnq",
    "brknrbnq",
    "brknrnqb",
    "rbbknrnq",
    "rkbbnrnq",
    "rkbnrbnq",
    "rkbnrnqb",
    "rbknbrnq",
    "rknbbrnq",
    "rknrbbnq",
    "rknrbnqb",
    "rbknrnbq",
    "rknbrnbq",
    "rknrnbbq",
    "rknrnqbb",
    "bbqrkrnn",
    "bqrbkrnn",
    "bqrkrbnn",
    "bqrkrnnb",
    "qbbrkrnn",
    "qrbbkrnn",
    "qrbkrbnn",
    "qrbkrnnb",
    "qbrkbrnn",
    "qrkbbrnn",
    "qrkrbbnn",
    "qrkrbnnb",
    "qbrkrnbn",
    "qrkbrnbn",
    "qrkrnbbn",
    "qrkrnnbb",
    "bbrqkrnn",
    "brqbkrnn",
    "brqkrbnn",
    "brqkrnnb",
    "rbbqkrnn",
    "rqbbkrnn",
    "rqbkrbnn",
    "rqbkrnnb",
    "rbqkbrnn",
    "rqkbbrnn",
    "rqkrbbnn",
    "rqkrbnnb",
    "rbqkrnbn",
    "rqkbrnbn",
    "rqkrnbbn",
    "rqkrnnbb",
    "bbrkqrnn",
    "brkbqrnn",
    "brkqrbnn",
    "brkqrnnb",
    "rbbkqrnn",
    "rkbbqrnn",
    "rkbqrbnn",
    "rkbqrnnb",
    "rbkqbrnn",
    "rkqbbrnn",
    "rkqrbbnn",
    "rkqrbnnb",
    "rbkqrnbn",
    "rkqbrnbn",
    "rkqrnbbn",
    "rkqrnnbb",
    "bbrkrqnn",
    "brkbrqnn",
    "brkrqbnn",
    "brkrqnnb",
    "rbbkrqnn",
    "rkbbrqnn",
    "rkbrqbnn",
    "rkbrqnnb",
    "rbkrbqnn",
    "rkrbbqnn",
    "rkrqbbnn",
    "rkrqbnnb",
    "rbkrqnbn",
    "rkrbqnbn",
    "rkrqnbbn",
    "rkrqnnbb",
    "bbrkrnqn",
    "brkbrnqn",
    "brkrnbqn",
    "brkrnqnb",
    "rbbkrnqn",
    "rkbbrnqn",
    "rkbrnbqn",
    "rkbrnqnb",
    "rbkrbnqn",
    "rkrbbnqn",
    "rkrnbbqn",
    "rkrnbqnb",
    "rbkrnqbn",
    "rkrbnqbn",
    "rkrnqbbn",
    "rkrnqnbb",
    "bbrkrnnq",
    "brkbrnnq",
    "brkrnbnq",
    "brkrnnqb",
    "rbbkrnnq",
    "rkbbrnnq",
    "rkbrnbnq",
    "rkbrnnqb",
    "rbkrbnnq",
    "rkrbbnnq",
    "rkrnbbnq",
    "rkrnbnqb",
    "rbkrnnbq",
    "rkrbnnbq",
    "rkrnnbbq",
    "rkrnnqbb"
  )

  private val positionsMap: Map[String, Int] = positions.zipWithIndex.toMap
