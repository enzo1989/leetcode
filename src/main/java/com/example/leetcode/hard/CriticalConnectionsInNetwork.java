package com.example.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network
 * where connections[i] = [a, b] represents a connection between servers a and b.
 * Any server can reach any other server directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 */
public class CriticalConnectionsInNetwork {
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        CriticalConnectionsInNetwork criticalConnectionsInNetwork = new CriticalConnectionsInNetwork();
        List<List<Integer>>  result = criticalConnectionsInNetwork.criticalConnections(n,connections);
        System.out.println(result);
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();


        return result;
    }
}
