package com.amouzakidis.challenge;

import java.util.*;

/*
    Word Search

    Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
    vertically neighboring. The same letter cell may not be used more than once.

 */
public class WordSearch {
    public static void main(String[] args) throws Exception {
        WordSearch wordSearch = new WordSearch();
        char[][] board1 = { { 'A','B','C','E' } ,
                            { 'S','F','E','S' } ,
                            { 'A','D','E','E' }
        };
        String word1 = "ABCESEEEFS";
        //boolean ret = wordSearch.exist( board1, word1);
        //if( !ret ) {
            //throw new Exception("It should return true");
        //}

        char[][] board2 = { { 'C', 'A', 'A' },
                            { 'A', 'A', 'A' },
                            { 'B', 'C', 'D' }
        };
        String word2 = "AAB";
        boolean ret2 = wordSearch.exist( board2, word2 );
        if( !ret2 ) {
            throw new Exception("It should return true");
        }

        char[][] board3 = { { 'A','A','A','A','A','A' },
                            { 'A','A','A','A','A','A' },
                            { 'A','A','A','A','A','A' },
                            { 'A','A','A','A','A','A' },
                            { 'A','A','A','A','A','A' },
                            { 'A','A','A','A','A','A' }
        };
        String word3 ="AAAAAAAAAAAAAAB";
        boolean ret3 = wordSearch.exist( board3, word3 );
        if( ret3 ) {
            throw new Exception("It should return false");
        }
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[ 0 ].length;
        if( word.length() > m * n ){
            return false;
        }
        //check if all characters exists in board
        Set<Character> boardChars = new HashSet<>();
        for(int i = 0; i < m; i ++ ) {
            for (int j = 0; j < n; j++) {
                boardChars.add(board[ i ][ j ]);
            }
        }
        for(int i = 0; i < word.length(); i ++ ){
            if(!boardChars.contains(word.charAt(i))){
                return false;
            }
        }
        //===========================================

        Map<List<String>, Boolean> memory = new HashMap<>();
        for(int i = 0; i < m; i ++ ){
            for(int j = 0; j < n; j ++ ){
                List<String> path = new ArrayList<>();
                if( isHereTheWord( board, i, j, word, path, memory ) ){
                    return true;
                }
            }
        }

        return false;
    }


    private boolean isHereTheWord( char[][] board, int x, int y, String word, List<String> path, Map<List<String>, Boolean> memory){
        String pathIndex = x + "_" + y;
        path.add(pathIndex);
        if( memory.containsKey( path ) ){
            return memory.get( path );
        }
        if( board[ x ][ y ] != word.charAt( 0 ) ){
            memory.put( path, false );
            return false;
        }
        if( word.length() == 1 && board[ x ][ y ] == word.charAt( 0 ) ) {
            memory.put( path, true );
            return true;
        }
        boolean found = false;
        if( x > 0){
            if( !path.contains( (x - 1) + "_"  + y ) ){
                found |= isHereTheWord( board, x - 1, y, word.substring( 1 ), new ArrayList<>( path ), memory );
            }
        }
        if( x < board.length - 1 ){
            if( !path.contains( (x + 1) + "_"  + y ) ){
                found |= isHereTheWord( board, x + 1, y, word.substring( 1 ), new ArrayList<>( path ), memory );
            }
        }

        if( y > 0){
            if( !path.contains( x + "_"  + ( y - 1 ) ) ){
                found |= isHereTheWord( board, x, y - 1, word.substring( 1 ), new ArrayList<>( path ), memory );
            }
        }
        if( y < board[ 0 ].length - 1 ){
            if( !path.contains( x + "_"  + ( y + 1 ) ) ){
                found |= isHereTheWord( board, x, y + 1, word.substring( 1 ), new ArrayList<>( path ),  memory );
            }
        }
        memory.put( path, found );
        return found;
    }
}
