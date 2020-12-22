package com.example.casino_19.Games.Poker;

import com.example.casino_19.Games.Game;
import com.example.casino_19.Games.Pieces.Card;
import com.example.casino_19.Games.Pieces.CardInterface;
import com.example.casino_19.Users.UserInterface;

public class Poker {
//    protected UserInterface[] users;
//    protected UserInterface winner;
//    protected CheckHandUtil rankUtil;

    /**
    PokerUtil is only called at the end of the game when comparing hands(5 community cards laid out, and 2 pocket cards per user)
    Comparisons are done with "7" cards in a hand(take best 5 out of 7)
     */
//    public Poker(UserInterface[] users)
//    {
//        this.users = users;
//        rankUtil = new CheckHandUtil();
//    }

//    /**
//     * returns winner of game
//     * @return winner
//     */
//    public UserInterface getWinner() {
//        return winner;
//    }
//
//    /**
//     * compare's players hands, ranks must be set before calling this method by calling setRank(user)
//     */
//    public void compareHands()
//    {
////        setRank(users[0]);
////        setRank(users[1]);
////        setRank(users[2]);
////        setRank(users[3]);
//
//        UserInterface best = users[0];
//        for(int i = 1; i<users.length; i++)
//        {
//            if(users[i].getUserRank()>best.getUserRank()) best = users[i];
//            else if(users[i].getUserRank()==best.getUserRank()) best = getBetterHand(best,users[i]);
//        }
//        winner = best;
//    }
//
//    /**
//     * sets the rank of the user based on what hand he/she holds
//     * @param user
//     */
//    public void setRank(UserInterface user)
//    {
//        if(rankUtil.isRoyalFlush(user.getCurrentHand())) user.setUserRank(10);
//        else if(rankUtil.isStraightFlush(user.getCurrentHand())) user.setUserRank(9);
//        else if(rankUtil.isFourKind(user.getCurrentHand())) user.setUserRank(8);
//        else if(rankUtil.isFullHouse(user.getCurrentHand())) user.setUserRank(7);
//        else if(rankUtil.isFlush(user.getCurrentHand())) user.setUserRank(6);
//        else if(rankUtil.isStraight(user.getCurrentHand())) user.setUserRank(5);
//        else if(rankUtil.isThreeKind(user.getCurrentHand())) user.setUserRank(4);
//        else if(rankUtil.isTwoPair(user.getCurrentHand())) user.setUserRank(3);
//        else if(rankUtil.isPair(user.getCurrentHand())) user.setUserRank(2);
//        else user.setUserRank(1);
//    }
//
//    /**
//     * compares 2 player's hands by their highest card rank
//     * @param user1
//     * @param user2
//     * @return
//     */
//    public UserInterface getBetterHand(UserInterface user1, UserInterface user2)
//    {
//        int rank = user1.getUserRank();
//        CardInterface[] user1hand = user1.getCurrentHand();
//        CardInterface[] user2hand = user2.getCurrentHand();
//
//        rankUtil.sortNoSuit(user1hand);
//        rankUtil.sortNoSuit(user2hand);
//
//        if(user1hand[6].getRank() > user2hand[6].getRank()) return user1;
//        else if(user1hand[6].getRank() < user2hand[6].getRank()) return user2;
//        else return null;
//
//    }
//
//    public String toString(Card[] cards)
//    {
//        String ret = "";
//        for(int i = 0; i<cards.length; i++)
//        {
//            ret += cards[i].getRank() + " of " + cards[i].getSuit() + "\n";
//        }
//        return ret;
//    }
}
