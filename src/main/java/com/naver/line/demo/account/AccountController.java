package com.naver.line.demo.account;import org.springframework.web.bind.annotation.*;import java.util.Date;@RestController@RequestMapping("/api/accounts")public class AccountController {  /**   * 1. 계좌 개설   */  @PostMapping("/")  public void makeAccount(@RequestHeader(value=" X-USER-ID") int userId,                          @RequestBody int transfer_limit,                          @RequestBody int daily_transfer_limit) {      // 1. userId 검증을 진행한 값이 없을 경우 401 에러를 처리한다      // 2. 사용자가 오늘 계좌를 이미 개설한 경우 400 에러 처리한다      // 3. 사용자가 3개 이상 계좌를 가지고 있는 경우 400 에러를 처리한다      // 4. JPA를 이용해서 서버에 등록한다.      // 5. 응답으로 현재 계좌 정보 리턴해준다(utils 이용) -> 타입 변경해줘야됨      return;  }  /**   * 2. 계좌 비활성화   */  @DeleteMapping(value = "/{id}")  public void deactivateAccount(@RequestHeader(value="X-USER-ID") int userId, @PathVariable int id) {    // 0. userId 검증을 진행한 값이 없을 경우 401 에러를 처리한다.    // 1. accounts 테이블에서 계좌 정보를 가져온다.    // 2. 계좌를 찾을 수 없을 경우 404 Not Found으로 응답합니다.    // 3. 사용자가 계좌의 소유자가 아닌 경우 403 Forbidden으로 응답합니다.    // 4. 사용자의 계좌의 상태가 이미 DISABLED인 경우 400 Bad Request로 응답합니다.    // 5. 사용자의 계좌의 잔액이 0원이 아닌 경우 400 Bad Request로 응답합니다.    // 6. 사용자의 계좌의 상태값을 DISABLED로 저장합니다.    //7. 응답으로 비활성화된 계좌 정보를 내려줍니다. -> dto를 생성해준다.    return;  }  /**   * 3. 계좌 이체 한도 수정   */  @PutMapping(value = "/{id}/transfer-limit")  public void updateAccountLimit(@RequestHeader(value = "X-USER-ID") int userId,                                 @PathVariable int id,                                 @RequestBody int transfer_limit,                                 @RequestBody int daily_transfer_limit) {      // 0. userId 검증을 진행한 값이 없을 경우 401 에러를 처리한다.      // 1. accountId 데이터 검증에 실패했을 경우 400 Bad Request로 응답합니다.      // 2. accounts 테이블에서 계좌 정보를 가져옵니다.      // 3. 계좌를 찾을 수 없을 경우 404 Not Found으로 응답합니다.      // 4. 사용자가 계좌의 소유자가 아닌 경우 403 Forbidden으로 응답합니다.      // 5. 사용자의 계좌가 비활성화 상태인 경우 400 Bad Request로 응답합니다.      // 6. 응답으로 수정된 계좌 정보를 내려줍니다.  }  /**   * 5. 계좌 입출금 내역   */  @GetMapping("/{id}/transactions")  public String getAccountTransactionHistory(@RequestHeader(value = "X-USER-ID") int userId,                                           @PathVariable int id,                                           @RequestParam long page,                                           @RequestParam int size,                                           @RequestParam String from_date,                                           @RequestParam String to_date) {      // 0. userId 검증을 진행한 값이 없을 경우 401 에러를 처리한다.      // 1. accounts 테이블에서 계좌 정보를 가져옵니다.      // 2. 계좌를 찾을 수 없을 경우 404 Not Found으로 응답합니다.      // 3. 사용자가 계좌의 소유자가 아닌 경우 403 Forbidden으로 응답합니다.      // 4. 사용자의 계좌가 비활성화 상태인 경우 400 Bad Request로 응답합니다.      // 5. balance_transactions 테이블에서 거래 내역을 가져옵니다.      // 6. page, size 값이 유효하지 않은 경우 기본값으로 대체합니다.      // 7. from_date, to_date 값이 유효하지 않은 경우 기본값으로 대체합니다.      // 8. to_date는 오늘보다 미래일 수 없습니다.      // 9. from_date는 to_date보다 미래일 수 없습니다.      // 10. 정렬은 최신순(내림차순)으로 정렬해주세요.      // 11. 응답으로 조회된 거래 내역을 내려줍니다.    System.out.println(userId);    System.out.println(id);    System.out.println(page);    System.out.println(size);    System.out.println(from_date);    System.out.println(to_date);    return "HELLO" + id;  }}