package com.example.casino_19.Games.Poker;

import com.example.casino_19.Games.Pieces.CardInterface;

public class CheckHandUtil {

//    /**
//    class deals with setting rank of the users' hands
//     */
//    public CheckHandUtil() {}
//
//    /**
//     * checks if hand is royal flush
//     * @param hand
//     * @return true or false
//     */
//    public boolean isRoyalFlush(CardInterface[] hand)
//    {
//        if(isFlush(hand)&&(hand[0].getRank()==1&&hand[1].getRank()==10&&hand[2].getRank()==11&&hand[3].getRank()==12&&hand[4].getRank()==13))
//            return true;
//        else if(isFlush(hand)&&(hand[1].getRank()==1&&hand[2].getRank()==10&&hand[3].getRank()==11&&hand[4].getRank()==12&&hand[5].getRank()==13))
//            return true;
//        else if(isFlush(hand)&&(hand[2].getRank()==1&&hand[3].getRank()==10&&hand[4].getRank()==11&&hand[5].getRank()==12&&hand[6].getRank()==13))
//            return true;
//        else
//            return false;
//    }
//
//    /**
//     * checks if hand is straight flush
//     * @param hand
//     * @return true or false
//     */
//    public boolean isStraightFlush(CardInterface[] hand)
//    {
//        return isFlush(hand)&&isStraight(hand);
//    }
//
//    /**
//     * checks if hand is four of a kind
//     * @param hand
//     * @return true or false
//     */
//    public boolean isFourKind(CardInterface[] hand)
//    {
//        sortNoSuit(hand);
//
//        if(hand[0].getRank()==hand[1].getRank()&&hand[1].getRank()==hand[2].getRank()&&hand[2].getRank()==hand[3].getRank())
//            return true;
//        else if(hand[1].getRank()==hand[2].getRank()&&hand[2].getRank()==hand[3].getRank()&&hand[3].getRank()==hand[4].getRank())
//            return true;
//        else if(hand[2].getRank()==hand[3].getRank()&&hand[3].getRank()==hand[4].getRank()&&hand[4].getRank()==hand[5].getRank())
//            return true;
//        else if(hand[3].getRank()==hand[4].getRank()&&hand[4].getRank()==hand[5].getRank()&&hand[5].getRank()==hand[6].getRank())
//            return true;
//        else
//            return false;
//    }
//
//
//    /**
//     * checks if hand is full house
//     * @param hand
//     * @return true or false
//     */
//    public boolean isFullHouse(CardInterface[] hand)
//    {
//        sortNoSuit(hand);
//
//        if(hand[0].getRank()==hand[1].getRank()&&hand[2].getRank()==hand[3].getRank()&&hand[3].getRank()==hand[4].getRank())
//            return true;
//        else if(hand[0].getRank()==hand[1].getRank()&&hand[3].getRank()==hand[4].getRank()&&hand[4].getRank()==hand[5].getRank())
//            return true;
//        else if(hand[0].getRank()==hand[1].getRank()&&hand[4].getRank()==hand[5].getRank()&&hand[5].getRank()==hand[6].getRank())
//            return true;
//        else if(hand[1].getRank()==hand[2].getRank()&&hand[3].getRank()==hand[4].getRank()&&hand[4].getRank()==hand[5].getRank())
//            return true;
//        else if(hand[1].getRank()==hand[2].getRank()&&hand[4].getRank()==hand[5].getRank()&&hand[5].getRank()==hand[6].getRank())
//            return true;
//        else if(hand[2].getRank()==hand[3].getRank()&&hand[4].getRank()==hand[5].getRank()&&hand[5].getRank()==hand[6].getRank())
//            return true;
//        else if(hand[0].getRank()==hand[1].getRank()&&hand[1].getRank()==hand[2].getRank()&&hand[3].getRank()==hand[4].getRank())
//            return true;
//        else if(hand[0].getRank()==hand[1].getRank()&&hand[1].getRank()==hand[2].getRank()&&hand[4].getRank()==hand[5].getRank())
//            return true;
//        else if(hand[0].getRank()==hand[1].getRank()&&hand[1].getRank()==hand[2].getRank()&&hand[5].getRank()==hand[6].getRank())
//            return true;
//        else if(hand[1].getRank()==hand[2].getRank()&&hand[2].getRank()==hand[3].getRank()&&hand[4].getRank()==hand[5].getRank())
//            return true;
//        else if(hand[1].getRank()==hand[2].getRank()&&hand[2].getRank()==hand[3].getRank()&&hand[5].getRank()==hand[6].getRank())
//            return true;
//        else if(hand[2].getRank()==hand[3].getRank()&&hand[3].getRank()==hand[4].getRank()&&hand[5].getRank()==hand[6].getRank())
//            return true;
//        else
//            return false;
//    }
//
//    /**
//     * checks if hand is a flush
//     * @param hand
//     * @return true or false
//     */
//    public boolean isFlush(CardInterface[] hand)
//    {
//        sortWithSuit(hand);
//        return (hand[0].getSuit().equals(hand[4].getSuit())||hand[1].getSuit().equals(hand[5].getSuit())||hand[2].getSuit().equals(hand[6].getSuit()));
//    }
//
//    /**
//     * checks if hand is a straight
//     * @param hand
//     * @return true or false
//     */
//    public boolean isStraight(CardInterface[] hand)
//    {
//        int count = 0;
//        boolean oneCount = false;
//        boolean tenCount = false;
//        boolean elevenCount = false;
//        boolean twelveCount = false;
//        boolean thirteenCount = false;
//
//        sortNoSuit(hand);
//        for(int i = 0; i < hand.length-1;i++)
//        {
//            if(hand[i].getRank()==1) oneCount = true;
//            if(hand[i].getRank()==10) tenCount = true;
//            if(hand[i].getRank()==11) elevenCount = true;
//            if(hand[i].getRank()==12) twelveCount = true;
//            if(hand[i].getRank()==13) thirteenCount = true;
//            if(hand[i].getRank()==hand[i+1].getRank()-1)
//            {
//                count++;
//            }
//            else if(hand[i].getRank()==hand[i+1].getRank())
//            {
//                //skip but don't increment count
//            }
//            else count = 0;
//            if(count>3) return true;
//            if(hand[6].getRank()==1) oneCount = true;
//            if(hand[6].getRank()==10) tenCount = true;
//            if(hand[6].getRank()==11) elevenCount = true;
//            if(hand[6].getRank()==12) twelveCount = true;
//            if(hand[6].getRank()==13) thirteenCount = true;
//            if(oneCount&&tenCount&&elevenCount&&twelveCount&&thirteenCount) return true;
//        }
//
//        return false;
//    }
//
//    /**
//     * checks if hand is three of a kind
//     * @param hand
//     * @return true or false
//     */
//    public boolean isThreeKind(CardInterface[] hand)
//    {
//        sortNoSuit(hand);
//
//        if(hand[0].getRank()==hand[1].getRank()&&hand[1].getRank()==hand[2].getRank())
//            return true;
//        else if(hand[1].getRank()==hand[2].getRank()&&hand[2].getRank()==hand[3].getRank())
//            return true;
//        else if(hand[2].getRank()==hand[3].getRank()&&hand[3].getRank()==hand[4].getRank())
//            return true;
//        else if(hand[3].getRank()==hand[4].getRank()&&hand[4].getRank()==hand[5].getRank())
//            return true;
//        else if(hand[4].getRank()==hand[5].getRank()&&hand[5].getRank()==hand[6].getRank())
//            return true;
//        else
//            return false;
//    }
//
//    /**
//     * checks if hand is two pair
//     * @param hand
//     * @return true or false
//     */
//    public boolean isTwoPair(CardInterface[] hand)
//    {
//        sortNoSuit(hand);
//        int count = 0;
//        if(hand[0].getRank()==hand[1].getRank()&&hand[1].getRank()!=hand[2].getRank()) count++;
//        if(hand[1].getRank()==hand[2].getRank()&&hand[2].getRank()!=hand[3].getRank()) count++;
//        if(hand[2].getRank()==hand[3].getRank()&&hand[3].getRank()!=hand[4].getRank()) count++;
//        if(hand[3].getRank()==hand[4].getRank()&&hand[4].getRank()!=hand[5].getRank()) count++;
//        if(hand[4].getRank()==hand[5].getRank()&&hand[5].getRank()!=hand[6].getRank()) count++;
//        if(hand[5].getRank()==hand[6].getRank()&&hand[5].getRank()!=hand[4].getRank()) count++;
//        return count > 1;
//    }
//
//    /**
//     * checks if hand is a pair
//     * @param hand
//     * @return true or false
//     */
//    public boolean isPair(CardInterface[] hand)
//    {
//        sortNoSuit(hand);
//        return ((hand[0].getRank()==hand[1].getRank())||(hand[1].getRank()==hand[2].getRank())||(hand[2].getRank()==hand[3].getRank())||(hand[3].getRank()==hand[4].getRank())||(hand[4].getRank()==hand[5].getRank())||(hand[5].getRank()==hand[6].getRank()));
//    }
//
//    /**
//     * sorts hand by checking it's suit first, then its rank
//     * @param hand
//     */
//    public void sortWithSuit(CardInterface[] hand)
//    {
//        for (int i = 0; i < hand.length - 1; ++i)
//        {
//            // find the "minimal" element to the right of position i
//            // sort by suit first, then by rank
//            int indexOfMin = findIndexOfMin(i,hand);
//
//            // swap the minimal element into position i
//            swap(i, indexOfMin, hand);
//        }
//    }
//
//    /**
//     * used by sortWithSuit, finds min index based on priority of suit then rank
//     * @param start
//     * @param hand
//     * @return min index
//     */
//    public int findIndexOfMin(int start, CardInterface[] hand)
//    {
//        int indexOfMin = start;
//        for (int j = start + 1; j < hand.length; ++j)
//        {
//            // look at the two cards, the minimal one we've found,
//            // and the one at the current position j
//            CardInterface min = hand[indexOfMin];
//            CardInterface current = hand[j];
//
//            // if current has a lower suit than the current min, then it should come
//            // first
//            if (current.getSuit().compareTo(min.getSuit()) < 0) //compare by enum, in order they're declared
//            {
//                indexOfMin = j;
//            }
//            else if (current.getSuit().equals(min.getSuit()))
//            {
//                // suits are the same, so compare ranks
//                if (current.getRank() < min.getRank())
//                {
//                    indexOfMin = j;
//                }
//            }
//            // otherwise, current does not come before min, so ignore it
//        }
//        return indexOfMin;
//    }
//
//    /**
//     * sorts hand by card ranks, ignoring suits
//     * @param hand
//     */
//    public void sortNoSuit(CardInterface[] hand)
//    {
//        // One by one move boundary of unsorted subarray
//        for (int i = 0; i < hand.length; i++)
//        {
//            // Find the minimum element in unsorted array
//            int min_idx = i;
//            for (int j = i+1; j < hand.length; j++)
//                if (hand[j].getRank() < hand[min_idx].getRank())
//                    min_idx = j;
//
//            // Swap the found minimum element with the first element
//            CardInterface temp = hand[min_idx];
//            hand[min_idx] = hand[i];
//            hand[i] = temp;
//        }
//    }
//
//    /**
//     * swaps position of cards
//     * @param i
//     * @param j
//     * @param hand
//     */
//    private void swap(int i, int j, CardInterface[] hand)
//    {
//        CardInterface c = hand[i];
//        hand[i] = hand[j];
//        hand[j] = c;
//    }
}
