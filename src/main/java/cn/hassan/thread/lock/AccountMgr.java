package cn.hassan.thread.lock;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/25 21:57
 * Description:
 */
public class AccountMgr {

    public static void transfer(Account from, Account to, double money) throws NotEnoughMoneyException {
        if (from.tryLock()) {
            try {
                if (to.tryLock()) {
                    try {
                        if (from.getMoney() >= money) {
                            from.reduce(money);
                            to.add(money);
                        } else {
                            throw new NotEnoughMoneyException();
                        }
                    } finally {
                        to.unLock();
                    }
                }
            } finally {
                from.unLock();
            }
        }
    }

    @Test
    public void test() {
        final int accountNum = 10;
        final Account[] accounts = new Account[accountNum];
        final Random rnd = new Random();
        for (int i = 0; i < accountNum; i++) {
            accounts[i] = new Account(rnd.nextInt(10000));
        }
        int threadNum = 100;
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(() -> {
                int loopNum = 100;
                for (int k = 0; k < loopNum; k++) {
                    int i1 = rnd.nextInt(accountNum);
                    int j = rnd.nextInt(accountNum);
                    int money = rnd.nextInt(10);
                    if (i1 != j) {
                        try {
                            transfer(accounts[i1], accounts[j], money);
                        } catch (NotEnoughMoneyException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            threads[i].start();
        }
    }
}
